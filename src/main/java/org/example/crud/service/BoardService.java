package org.example.crud.service;

import org.example.crud.model.Board;
import org.example.crud.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 전체 게시글 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // 게시글 ID로 조회
    public Board getBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 게시글 저장
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시글 삭제
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
