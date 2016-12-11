package com.dns.feedbox.util;

import com.dns.feedbox.entity.Description;
import com.dns.feedbox.entity.Feed;
import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.messaging.Message;

import java.util.stream.Collectors;

/**
 * Created by dinusha on 10/12/16.
 */
public class FeedTransformer {

    public Feed transformToFeed(Message<SyndEntry> message){
        SyndEntry entity = message.getPayload();
        System.out.println(entity);
        Feed feed = new Feed();
        feed.setTitle(entity.getTitle());
        feed.setUrl(entity.getLink());
        feed.setTags(entity.getCategories().stream().map( c-> c.getName()).collect(Collectors.toList()));
        System.out.println("catogorises :"+entity.getCategories().size());
        feed.setPublishDate(entity.getPublishedDate());
        Description des = new Description(entity.getDescription().getType(),entity.getDescription().getValue());
        feed.setDescription(des);
        return  feed;


    }

    public String transform(Message<SyndEntry> message){
        SyndEntry entity = message.getPayload();
        Feed feed = new Feed();
        feed.setTitle(entity.getTitle());
        feed.setUrl(entity.getLink());
        return  feed.getTitle()+" - "+feed.getUrl();

    }
}
