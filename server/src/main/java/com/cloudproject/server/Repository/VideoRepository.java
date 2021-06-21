package com.cloudproject.server.Repository;

import com.cloudproject.server.Model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video, String> {
    Video findVideoById(String id);
}
