package com.one.portfoilo.domain.board;

import io.jsonwebtoken.lang.Assert;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;

    public Board(String title, int price) {
        Assert.hasText(title, "게시물 제목은 필수 사항입니다");
        Assert.isTrue(price>0, "게시물 가격은 0이상이어야 합니다");
        this.title = title;
        this.price = price;
    }

    public void assignId(Long id) {
        this.id = id;
    }
}
