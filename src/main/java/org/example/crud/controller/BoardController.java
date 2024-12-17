package org.example.crud.controller;

import org.example.crud.model.Board;
import org.example.crud.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 전체 게시글 조회
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    // ID로 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(board);
    }

    // 게시글 생성
    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.saveBoard(board);
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board updatedBoard) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return ResponseEntity.notFound().build();
        }
        board.setTitle(updatedBoard.getTitle());
        board.setContent(updatedBoard.getContent());
        board.setWriter(updatedBoard.getWriter());
        return ResponseEntity.ok(boardService.saveBoard(board));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
