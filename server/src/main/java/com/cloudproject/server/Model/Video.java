package com.cloudproject.server.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "video")
public class Video {
    @Id
    private ObjectId _id;
    private String id;
    private String title;
    private String description;
    @DBRef
    private Snippet snippet;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Snippet getVideoSnippet() {
        return snippet;
    }
}
