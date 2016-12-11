package com.dns.feedbox.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by dinusha on 9/12/16.
 */
@ToString
@Document(collection = "data")
public class Feed implements Serializable{

    @Getter @Setter @Id private String id;
    @Getter @Setter private String title;

    @Getter @Setter private String url;
    @Getter @Setter private Description description;

    @Indexed
    @Getter @Setter private List<String> tags;
    @Indexed(unique = true,sparse = true)
    @Getter @Setter private Date publishDate;



}