package me.songha.mongo.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;

    @PostMapping("/board")
    public Board save(@RequestBody BoardSaveDto dto) { // {"title":"제목1","content":"내용1"}
        return boardRepository.save(dto.toEntity());
    }

    @GetMapping("/board/{id}")
    public Board findById(@PathVariable String id) {
        return boardRepository.findById(id).get();
    }

    @GetMapping("/board")
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    @PutMapping("board/{id}")
    public void update(@RequestBody BoardSaveDto dto, @PathVariable String id) {
        Board board = dto.toEntity();
        board.setId(id); // update
        boardRepository.save(board);
    }

    @DeleteMapping("board/{id}")
    public int deleteById(@PathVariable String id) {
        boardRepository.deleteById(id);
        return 1;
    }

}