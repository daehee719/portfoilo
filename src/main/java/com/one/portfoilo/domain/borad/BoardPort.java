package com.one.portfoilo.domain.borad;

import org.springframework.stereotype.Component;

@Component
public interface BoardPort
{
    void save(final Board board);
}