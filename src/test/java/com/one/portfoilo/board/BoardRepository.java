package com.one.portfoilo.board;

import java.util.HashMap;
import java.util.Map;

public class BoardRepository {
    private Long sequence = 0L;
    private Map<Long, Board> persistence = new HashMap<>();

    public void save(final Board board) {
        board.assignId(++sequence);
        persistence.put(board.getId(), board);
    }
}