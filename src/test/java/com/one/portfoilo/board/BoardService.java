package com.one.portfoilo.board;

public class BoardService {
    private final BoardPort boardPort;

    public BoardService(BoardPort boardPort) {
        this.boardPort = boardPort;
    }

    public void addBoard(AddBoardRequest request) {
        final Board board = new Board(request.title(), request.price());

        boardPort.save(board);
    }
}