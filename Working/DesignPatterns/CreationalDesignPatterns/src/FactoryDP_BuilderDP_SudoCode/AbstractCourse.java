package FactoryDP_BuilderDP_SudoCode;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCourse implements ICourse {

    private String name;
    private String author;
    private List<IModule> modules = new ArrayList<>();
    private Integer rating;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setModules(List<IModule> modules) {
        this.modules = modules;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public List<IModule> getModules() {
        return this.modules;
    }

    @Override
    public Integer getRating() {
        return this.rating;
    }

    @Override
    public void addModule(IModule module){
        this.getModules().add(module);
    }

    @Override
    public String toString() {
        return "AbstractCourse{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", modules=" + modules +
                ", rating=" + rating +
                '}';
    }
}
