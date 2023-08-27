package FactoryDP_BuilderDP_SudoCode;

import java.util.List;

public interface ICourse {
    public String getName();
    public String getAuthor();
    public List<IModule> getModules();
    public void addModule(IModule module);
    public Integer getRating();
}
