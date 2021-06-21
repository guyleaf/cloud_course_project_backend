package com.cloudproject.server.Service;

import com.cloudproject.server.Model.DailyRank;
import com.cloudproject.server.Repository.DailyRankRepository;
import com.fasterxml.jackson.core.JsonParser;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankService {
    private final DailyRankRepository dailyRankRepository;

    @Autowired
    public RankService(DailyRankRepository dailyRankRepository) {
        this.dailyRankRepository = dailyRankRepository;
    }

    public List<String> getVideoRanksByCategoryIdAndCollectedDate(String categoryId, String collectedDate, int page, int size) {
        DailyRank rank = this.dailyRankRepository.findDailyRankByCategoryIdAndCollectedDate(categoryId, collectedDate);
        PagedListHolder<String> paged = new PagedListHolder<>(rank.getVideoRanks());
        paged.setPageSize(size);
        paged.setPage(page);

        return paged.getPageList();
    }

    public int countVideoRanksByCategoryIdAndCollectedDate(String categoryId, String collectedDate) {
        DailyRank rank = this.dailyRankRepository.findDailyRankByCategoryIdAndCollectedDate(categoryId, collectedDate);
        return rank.getVideoRanks().size();
    }

    public boolean checkCollectedDateExists(String categoryId, String collectedDate) {
        return this.dailyRankRepository.existsDailyRankByCategoryIdAndCollectedDate(categoryId, collectedDate);
    }

    public List<String> getAvailableDate(String categoryId) {
        return this.dailyRankRepository.findAllDateByCategoryId(categoryId).stream().map(object -> {
            JSONTokener token = new JSONTokener(object);
            JSONObject json = new JSONObject(token);
            return json.getString("collectedDate");
        }).collect(Collectors.toList());
    }
}
