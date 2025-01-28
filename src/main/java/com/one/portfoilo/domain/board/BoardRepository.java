package com.one.portfoilo.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
interface BoardRepository extends JpaRepository<Board, Integer> {
}