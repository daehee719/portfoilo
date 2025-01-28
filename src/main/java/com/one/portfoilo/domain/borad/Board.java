package com.one.portfoilo.domain.borad;

import io.jsonwebtoken.lang.Assert;

public class Board {
    private final String title;
    private final int price;
    private Long id;

    public Board(String title, int price) {
        Assert.hasText(title, "게시물 제목은 필수 사항입니다");
        Assert.isTrue(price>0, "게시물 가격은 0이상이어야 합니다");
        this.title = title;
        this.price = price;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
