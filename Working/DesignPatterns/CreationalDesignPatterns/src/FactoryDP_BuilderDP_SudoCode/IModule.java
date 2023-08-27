package FactoryDP_BuilderDP_SudoCode;

import java.util.List;

public interface IModule {
    public List<ITopic> getTopics();
    public String getModuleName();
    public Integer getTotalTime();
    public ICourse getAssociatedCourse();
    public void addTopic(ITopic topic);
}
