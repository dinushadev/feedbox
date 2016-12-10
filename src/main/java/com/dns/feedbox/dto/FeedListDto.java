package com.dns.feedbox.dto;

import com.dns.feedbox.entity.Feed;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dinusha on 11/12/16.
 */
public class FeedListDto implements Serializable{

    @Getter @Setter private List<Feed> feeds;
    @Getter @Setter private String source;

    public FeedListDto(List<Feed> feeds) {
        this.feeds = feeds;
    }
}
