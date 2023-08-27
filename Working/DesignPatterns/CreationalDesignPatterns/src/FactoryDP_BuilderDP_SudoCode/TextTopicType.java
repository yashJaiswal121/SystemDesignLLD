package FactoryDP_BuilderDP_SudoCode;

import java.util.Arrays;

public class TextTopicType implements ITopic{

    private String topicName;
    private Integer length;
    private final TopicMediaType mediaType  = TopicMediaType.TEXT;
    private TopicCodecType codecType;
    private Byte[] data;

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setCodecType(TopicCodecType codecType) {
        this.codecType = codecType;
    }

    public void setData(Byte[] data) {
        this.data = data;
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
        return "TextTopicType{" +
                "topicName='" + topicName + '\'' +
                ", length=" + length +
                ", mediaType=" + mediaType +
                ", codecType=" + codecType +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
