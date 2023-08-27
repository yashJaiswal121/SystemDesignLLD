package FactoryDP_BuilderDP_SudoCode;

import java.util.ArrayList;
import java.util.List;

public class FactoryDP_SudoCode {

    public static void main(String[] args) throws Exception{

        //Factory Design Pattern - SudoCode
        //Factory Gives the Object which are very
        KafkaCourse course1 = (KafkaCourse) CourseFactory.getCourse(KafkaCourse.class);

        ModuleTemplate module1 = new ModuleTemplate();
        module1.setModuleName("KAFKA ECOSYSTEM - THE BIG PICTURE");
    //    module1.setAssociatedCourse(course1);
        module1.setTopics(getDummyModuleTopics());

        ModuleTemplate module2 = new ModuleTemplate();
        module2.setModuleName("APACHE KAFKA - GETTING STARTED");
 //       module2.setAssociatedCourse(course1);
        module2.setTopics(getDummyModuleTopics2());

        course1.setModules(new ArrayList<>());
        course1.addModule(module1);
        course1.addModule(module2);

        course1.setAuthor("Author1");
        course1.setName("Kafka Course - An introductory course");
        course1.setRating(4);


        System.out.println("Kafka Course Details : " + course1);

    }

    private static List<ITopic> getDummyModuleTopics(){

        //Builder Design Pattern - SudoCode
        VideoTopicType.Builder videoTopicBuilder = new VideoTopicType.Builder();
        VideoTopicType videoTopicType = videoTopicBuilder.setTopicName("What is Apache Kafka?").setCodecType(TopicCodecType.MP4).setLength(1150).setData(null).build();

        VideoTopicType.Builder videoTopicBuilder2 = new VideoTopicType.Builder();
        VideoTopicType videoTopicType2 = videoTopicBuilder2.setTopicName("Apache Kafka core concepts").setCodecType(TopicCodecType.MP4).setLength(1150).setData(null).build();

        TextTopicType textTopicType = new TextTopicType();
        textTopicType.setTopicName("Inportant Notes");
        textTopicType.setCodecType(TopicCodecType.PDF);
        textTopicType.setLength(2000);
        textTopicType.setData(null);

        List<ITopic> topicList = new ArrayList<>();
        topicList.add(videoTopicType);
        topicList.add(videoTopicType2);
        topicList.add(textTopicType);

        return topicList;
    }

    private static List<ITopic> getDummyModuleTopics2(){

        VideoTopicType.Builder builder = new VideoTopicType.Builder();
        VideoTopicType videoTopicType = builder.setTopicName("Kafka Quick Start").setCodecType(TopicCodecType.MP4).setLength(1150).setData(null).build();

        VideoTopicType.Builder builder2 = new VideoTopicType.Builder();
        VideoTopicType videoTopicType2 = builder2.setTopicName("Installing Single Node Kafka Cluster").setCodecType(TopicCodecType.MP4).setLength(1150).setData(null).build();

        TextTopicType textTopicType = new TextTopicType();
        textTopicType.setTopicName("Inportant Notes");
        textTopicType.setCodecType(TopicCodecType.PDF);
        textTopicType.setLength(1000);
        textTopicType.setData(null);

        List<ITopic> topicList = new ArrayList<>();
        topicList.add(videoTopicType);
        topicList.add(videoTopicType2);
        topicList.add(textTopicType);

        return topicList;
    }

}
