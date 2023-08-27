package FactoryDP_BuilderDP_SudoCode;

import java.util.HashMap;
import java.util.Map;

public enum TopicMediaType {
    AUDIO("audio"),
    VIDEO("video"),
    TEXT("text");

    private static final Map<String,TopicMediaType> enumMap = new HashMap<>();
    private final String type;

    private TopicMediaType(String type){
        this.type = type;

    }

    static {
        for(TopicMediaType topicType : values())
            enumMap.put(topicType.toString(),topicType);
    }

    @Override
    public String toString(){
        return type;
    }

    public static TopicMediaType fromString(final String value) {
        return enumMap.get(value);
    }

}
