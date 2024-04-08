package com.example.shop.Entity;

import lombok.Data;

@Data
public class Pair {
    private Long id;
    private Long count;
    private Long size;

    public Long getCount(){
        return this.count;
    }
    public Long getId(){
        return this.id;
    }
}
