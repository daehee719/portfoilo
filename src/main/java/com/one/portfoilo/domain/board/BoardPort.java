package com.one.portfoilo.domain.board;

import org.springframework.stereotype.Component;

@Component
public interface BoardPort
{
    void save(final Board board);
}