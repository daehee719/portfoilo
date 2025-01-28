package com.one.portfoilo.domain.borad;

import org.springframework.stereotype.Component;

@Component
public class BoardAdapter implements BoardPort {
    private final BoardRepository boardRepository;

    public BoardAdapter(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void save(Board board) {
        boardRepository.save(board);
    }
}