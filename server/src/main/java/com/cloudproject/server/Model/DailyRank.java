package com.cloudproject.server.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "dailyRank")
public class DailyRank {
    @Id
    private ObjectId _id;
    private String categoryId;
    private String collectedDate;
    private List<String> videoRanks;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCollectedDate() {
        return collectedDate;
    }

    public List<String> getVideoRanks() {
        return videoRanks;
    }
}
