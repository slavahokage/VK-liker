package vc;

/**
 * Created by USER on 24.05.2018.
 */
public enum LikeObjectType {
    POST("post"),
    COMMENT("comment"),
    PHOTO("photo"),
    AUDIO("audio"),
    VIDEO("video"),
    NOTE("note"),
    MARKET("market");

    private final String type;

    LikeObjectType(final String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}
