package com.dns.feedbox.repo;

import com.dns.feedbox.entity.Feed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dinusha on 11/12/16.
 */
@Repository
public interface FeedRepo  extends MongoRepository<Feed,String>{

}

