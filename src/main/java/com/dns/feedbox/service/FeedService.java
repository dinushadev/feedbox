package com.dns.feedbox.service;

import com.dns.feedbox.entity.Feed;
import com.dns.feedbox.repo.FeedRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dinusha on 11/12/16.
 */
@Service
public class FeedService {

    private FeedRepo feedRepo;

    public FeedService(FeedRepo feedRepo) {
        this.feedRepo = feedRepo;
    }

    public List<Feed> getAllFeeds() {
       return feedRepo.findAll();
    }
}
