package com.one.portfoilo.board;

import com.one.portfoilo.domain.borad.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void 게시물등록()
    {
        final AddBoardRequest request = 게시물등록요청();
        boardService.addBoard(request);
    }

    private static AddBoardRequest 게시물등록요청()
    {
        final String title= "게시물 제목";
        final int price = 1000;
        return new AddBoardRequest(title, price);
    }
}
