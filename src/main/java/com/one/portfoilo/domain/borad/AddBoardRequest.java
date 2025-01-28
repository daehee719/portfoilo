package com.one.portfoilo.domain.borad;

import io.jsonwebtoken.lang.Assert;

public record AddBoardRequest(String title, int price) {
    public AddBoardRequest {
        Assert.hasText(title, "게시물 제목은 필수 사항입니다.");
        Assert.isTrue(price>0, "게시물 가격은 0이상이어야 합니다");
    }
}