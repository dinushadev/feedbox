package com.dns.feedbox.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dinusha on 11/12/16.
 */
public class Description {

    @Getter @Setter private  String desc;
    @Getter @Setter private  String type;

    public Description(String type, String value) {
        this.type = type;
        this.desc = value;
    }
}
