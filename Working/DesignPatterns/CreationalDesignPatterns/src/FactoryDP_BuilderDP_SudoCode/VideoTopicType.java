package FactoryDP_BuilderDP_SudoCode;

import java.util.Arrays;
//Steps for Builder Design Pattern
public class VideoTopicType implements ITopic{
    //Step0: Declare fields of Outerclass and Have only the getters() of those fields.
    private String topicName;
    private Integer length;
    private final TopicMediaType mediaType = TopicMediaType.VIDEO;
    private TopicCodecType codecType;
    private Byte[] data;

    //Step1: Make a Static Nested class as name Builder
    static class Builder{
        //Step2: The Fields of Builder will be same as The Outer Class whose Builder it is.
        private String topicName;
        private Integer length;
        private TopicCodecType codecType;
        private Byte[] data;

        public Builder setTopicName(String topicName) {
            this.topicName = topicName;
            return this; //Step3: Make only setters of fields in it, and all of them will return the current Builder object using this.
        }

        public Builder setLength(Integer length) {
            this.length = length;
            return this;
        }

        public Builder setCodecType(TopicCodecType codecType) {
            this.codecType = codecType;
            return this;
        }

        public Builder setData(Byte[] data) {
            this.data = data;
            return this;
        }
        //Step4: Have a build() method in inner class returning a new Object of Outer class prepared from inner Builder Object
        public VideoTopicType build(){
            return new VideoTopicType(this);
        }

    }

    //Step5: Have the constructor in Outer class to support the Step4
    public VideoTopicType(Builder builder){
        this.topicName = builder.topicName;
        this.length = builder.length;
        this.codecType = builder.codecType;
        this.data = builder.data;
    }

    @Override
    public Integer getLength() {
        return this.length;
    }

    @Override
    public String getTopicName() {
        return this.topicName;
    }

    @Override
    public TopicMediaType getMediaType() {
        return this.mediaType;
    }

    @Override
    public TopicCodecType getCodecType() {
        return this.codecType;
    }

    @Override
    public Byte[] getData(){
        return this.data;
    }


    @Override
    public String toString() {
        return "VideoTopicType{" +
                "topicName='" + topicName + '\'' +
                ", length=" + length +
                ", mediaType=" + mediaType +
                ", codecType=" + codecType +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
