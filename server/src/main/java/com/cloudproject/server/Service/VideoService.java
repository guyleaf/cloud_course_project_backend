package com.cloudproject.server.Service;

import com.cloudproject.server.Model.Video;
import com.cloudproject.server.Repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findVideosById(List<String> ids) {
        return ids.stream().map(this.videoRepository::findVideoById).collect(Collectors.toList());
    }
}
