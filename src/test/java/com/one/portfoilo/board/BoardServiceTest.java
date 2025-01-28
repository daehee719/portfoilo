package com.one.portfoilo.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BoardServiceTest {

    private BoardService boardService;
    private BoardPort boardPort;
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        boardRepository = new BoardRepository();
        boardPort = new BoardAdapter(boardRepository);
        boardService = new BoardService(boardPort);
    }

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
