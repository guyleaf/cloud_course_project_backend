package com.cloudproject.server.Model;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class Snippet {
    private String channelId;
    private String channelTitle;
    private String categoryId;
    @DBRef
    private Thumbnail thumbnail;
    private String viewCount;
    private String duration;

    public String getChannelId() {
        return channelId;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public String getViewCount() {
        return viewCount;
    }

    public String getDuration() {
        return duration;
    }
}
