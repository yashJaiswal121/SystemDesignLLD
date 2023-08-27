package FactoryDP_BuilderDP_SudoCode;

import java.util.List;

public abstract class AbstractModule implements IModule {

    private String moduleName;
    private List<ITopic> topics;
    private Integer totalTime = 0;
    private ICourse associatedCourse;

    @Override
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public List<ITopic> getTopics() {
        return topics;
    }

    public void setTopics(List<ITopic> topics) {
        this.topics = topics;
        this.totalTime = calculateTotalTime();
    }

    @Override
    public Integer getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public ICourse getAssociatedCourse() {
        return associatedCourse;
    }

    public void setAssociatedCourse(ICourse associatedCourse) {
        this.associatedCourse = associatedCourse;
    }

    @Override
    public void addTopic(ITopic topic){
        this.topics.add(topic);
        this.totalTime += topic.getLength();
    }

    private Integer calculateTotalTime(){
        return this.topics.stream().map(topic -> topic.getLength()).reduce(0,(len1, len2) -> len1 + len2);
    }

    @Override
    public String toString() {
        return "AbstractModule{" +
                "moduleName='" + moduleName + '\'' +
                ", topics=" + topics +
                ", totalTime=" + totalTime +
                ", associatedCourse=" + associatedCourse +
                '}';
    }
}
