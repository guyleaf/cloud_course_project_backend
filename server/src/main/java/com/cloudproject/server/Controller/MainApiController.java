package com.cloudproject.server.Controller;

import com.cloudproject.server.Model.Category;
import com.cloudproject.server.Model.VideoJsonResponse;
import com.cloudproject.server.Service.CategoryService;
import com.cloudproject.server.Service.RankService;

import com.cloudproject.server.Service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1")
public class MainApiController {
    private final VideoService videoService;
    private final RankService rankService;
    private final CategoryService categoryService;

    @Autowired
    public MainApiController(VideoService videoService, RankService rankService, CategoryService categoryService) {
        this.videoService = videoService;
        this.rankService = rankService;
        this.categoryService = categoryService;
    }

    @GetMapping("videos")
    @ResponseBody
    public VideoJsonResponse videos(@RequestParam String categoryId, @RequestParam String date, @RequestParam(defaultValue = "0") @Min(0) int page, @RequestParam(defaultValue = "10") @Min(1) @Max(30) int size) {
        if (!this.categoryService.checkCategoryExists(categoryId)) {
            throw new NullPointerException("Category not found.");
        }
        else if (!this.rankService.checkCollectedDateExists(categoryId, date)) {
            throw new NullPointerException("Request date not found.");
        }

        return new VideoJsonResponse(categoryId, this.rankService.countVideoRanksByCategoryIdAndCollectedDate(categoryId, date), this.videoService.findVideosById(this.rankService.getVideoRanksByCategoryIdAndCollectedDate(categoryId, date, page, size)));
    }

    @GetMapping("category")
    @ResponseBody
    public List<Category> category() {
        return this.categoryService.getCategories();
    }

    @GetMapping("date")
    @ResponseBody
    public List<String> date(@RequestParam String categoryId) {
        if (!this.categoryService.checkCategoryExists(categoryId)) {
            throw new NullPointerException("Category not found.");
        }

        return this.rankService.getAvailableDate(categoryId);
    }
}
