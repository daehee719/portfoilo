package com.one.portfoilo.board.service;

import com.jayway.jsonpath.JsonPath;
import io.jsonwebtoken.lang.Assert;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        final String title= "게시물 제목";
        final Integer price = 1000;
        final AddBoardRequest request = new AddBoardRequest(title, price);
        boardService.addBoard(request);
    }


    private record AddBoardRequest(String title, int price) {
        private AddBoardRequest {
            Assert.hasText(title, "게시물 제목은 필수 사항입니다.");
            Assert.isTrue(price>0, "게시물 가격은 0이상이어야 합니다");
        }
    }
    private interface BoardPort
    {
        void save(final Board board);
    }

    private class BoardService {
        private final BoardPort boardPort;

        private BoardService(BoardPort boardPort) {
            this.boardPort = boardPort;
        }

        public void addBoard(AddBoardRequest request) {
            final Board board = new Board(request.title, request.price);

            boardPort.save(board);
        }
    }


    private class Board {
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

    private class BoardAdapter implements BoardPort {
        private final BoardRepository boardRepository;

        private BoardAdapter(BoardRepository boardRepository) {
            this.boardRepository = boardRepository;
        }

        @Override
        public void save(Board board) {
            boardRepository.save(board);
        }
    }


    private class BoardRepository {
        private Long sequence = 0L;
        private Map<Long, Board> persistence = new HashMap<>();

        public void save(final Board board) {
            board.assignId(++sequence);
            persistence.put(board.getId(), board);
        }
    }
}
