package FactoryDP_BuilderDP_SudoCode;

import java.util.Arrays;

public class VideoTopicType implements ITopic{

    private String topicName;
    private Integer length;
    private final TopicMediaType mediaType = TopicMediaType.VIDEO;
    private TopicCodecType codecType;
    private Byte[] data;

    static class Builder{

        private String topicName;
        private Integer length;
        private TopicCodecType codecType;
        private Byte[] data;

        public Builder setTopicName(String topicName) {
            this.topicName = topicName;
            return this;
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

        public VideoTopicType build(){
            return new VideoTopicType(this);
        }

    }

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
