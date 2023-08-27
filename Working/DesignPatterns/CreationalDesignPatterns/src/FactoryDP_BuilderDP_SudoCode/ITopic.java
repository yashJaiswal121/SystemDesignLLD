package FactoryDP_BuilderDP_SudoCode;

public interface ITopic {
    public Integer getLength();
    public String getTopicName();
    public TopicMediaType getMediaType();
    public TopicCodecType getCodecType();
    public Byte[] getData();
}
