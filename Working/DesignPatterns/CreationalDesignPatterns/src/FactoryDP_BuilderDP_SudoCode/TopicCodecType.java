package FactoryDP_BuilderDP_SudoCode;

import java.util.HashMap;
import java.util.Map;

public enum TopicCodecType {
    MP3("mp3"),
    MP4("mp4"),
    PDF("pdf");

    private static final Map<String, TopicCodecType> enumMap = new HashMap<>();
    private final String type;

    private TopicCodecType(String type){
        this.type = type;
    }

    static {
        for(TopicCodecType codecType : values())
            enumMap.put(codecType.toString(),codecType);
    }

    @Override
    public String toString(){
        return type;
    }

    public static TopicCodecType fromString(final String value) {
        return enumMap.get(value);
    }
}
