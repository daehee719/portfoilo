package com.one.portfoilo.domain.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class BoardService {
    private final BoardPort boardPort;

    public BoardService(BoardPort boardPort) {
        this.boardPort = boardPort;
    }

    @PostMapping("/board")
    public ResponseEntity<?> addBoard(@RequestBody AddBoardRequest request) {
        final Board board = new Board(request.title(), request.price());

        boardPort.save(board);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}