package com.fcs.board.adapter.web;

import com.fcs.board.adapter.web.dto.BoardRequest;
import com.fcs.board.adapter.web.dto.BoardResponse;
import com.fcs.board.application.usecases.CreateBoardUseCase;
import com.fcs.board.domain.Board;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {
    private final CreateBoardUseCase createBoardUseCase;

    public BoardController(CreateBoardUseCase createBoardUseCase) {
        this.createBoardUseCase = createBoardUseCase;
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@Valid @RequestBody BoardRequest request) {
        Board board = createBoardUseCase.execute(request.name());
        return ResponseEntity.ok(new BoardResponse(board.getId(), board.getName()));
    }
}
