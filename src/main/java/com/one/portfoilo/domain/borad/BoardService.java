package com.one.portfoilo.domain.borad;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BoardService {
    private final BoardPort boardPort;

    public BoardService(BoardPort boardPort) {
        this.boardPort = boardPort;
    }

    @Transactional
    public void addBoard(AddBoardRequest request) {
        final Board board = new Board(request.title(), request.price());

        boardPort.save(board);
    }
}