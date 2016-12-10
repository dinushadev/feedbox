package com.dns.feedbox.controller;

import com.dns.feedbox.dto.FeedListDto;
import com.dns.feedbox.entity.Feed;
import com.dns.feedbox.service.FeedService;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dinusha on 11/12/16.
 */
@RestController
@RequestMapping("/feed")
public class FeedController {

    private FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @RequestMapping("/")
    public FeedListDto getAll(){
        List<Feed> feeds = feedService.getAllFeeds();

        FeedListDto feedsDto = new FeedListDto(feeds);
        return  feedsDto;
    }
}
