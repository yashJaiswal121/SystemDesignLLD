import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;
import java.io.IOException;

public class GitBranchesAutomation {
    public static void main(String[] args) {
        // Replace these values with your repository's path and the commit hash to cherry-pick.
        String repositoryPath = "D:/EnergyIP_Platform_GIT/energyip/.git";
        String commitToCherryPick = "69c48040d9ee3bdba5a65b450c9db335a59e7b08";
        String[] sourceBranchNames = {
                "origin/hotfix/hsvu/9.0.3",
                "origin/hotfix/deo/9.0.3",
        };
        String[] newBranchNames = {"EIPMDM-68278"};


        try {
            FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder().setGitDir(new File(repositoryPath));
            try (Repository repository = repositoryBuilder.build()) {
                Git git = new Git(repository);

                // Checkout the source branch
                for(int i=0;i<sourceBranchNames.length;i++){

                    String sourceBranchName = sourceBranchNames[i];
                    String newBranchName = newBranchNames[0] + "-" + sourceBranchName;

                    try{
                        git.checkout().setName(sourceBranchName).call();
                        // Create a new branch
                        //git.checkout().setCreateBranch(true).setName(newBranchName).call();

                        if(repository.resolve(newBranchName) != null){
                            git.branchDelete()
                                    .setBranchNames(newBranchName)
                                    .setForce(true) // Use force to delete the branch even if it's not fully merged
                                    .call();
                        }else
                            git.checkout()
                                    .setCreateBranch(true)
                                    .setName(newBranchName)
                                    .setUpstreamMode(CreateBranchCommand.SetupUpstreamMode.TRACK)
                                    .call();

                        // Cherry-pick the commit
                        CherryPickCommand cherryPickCommand = git.cherryPick();
                        cherryPickCommand.include(repository.resolve(commitToCherryPick));
                        cherryPickCommand.call();


                        CheckoutCommand checkoutCommand = git.checkout();
                        checkoutCommand.setName("master");
                        checkoutCommand.call();

                        System.out.println("Successfull in cherrypicking!" + sourceBranchName);

                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Error in cherrypicking!" + sourceBranchName);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
