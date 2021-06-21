package com.cloudproject.server.Model;

import java.util.List;

public class VideoJsonResponse {
    private final String categoryId;
    private final int count;
    private final List<Video> items;

    public VideoJsonResponse(String categoryId, int count, List<Video> items) {
        this.categoryId = categoryId;
        this.count = count;
        this.items = items;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public int getCount() {
        return count;
    }

    public List<Video> getItems() {
        return items;
    }
}
