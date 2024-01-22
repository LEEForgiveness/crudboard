package hello.crudboard.web.basic;

import hello.crudboard.domain.board.Board;
import hello.crudboard.domain.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/boards")
@RequiredArgsConstructor
public class BasicBoardController {

    private final BoardRepository boardRepository;

    @GetMapping
    public String boards(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);

        return "basic/boards";
    }

    @GetMapping("/{boardId}")
    public String board(@PathVariable("boardId") long boardId, Model model){
        Board board = boardRepository.findById(boardId);
        model.addAttribute("board", board);
        return "basic/board";
    }

    @GetMapping("/add")
    public String addForm(){
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addBoard(Board board, Model model, RedirectAttributes redirectAttributes){
        Board saveBoard = boardRepository.save(board);
        redirectAttributes.addAttribute("boardId", saveBoard.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/boards/{boardId}";
    }

    @PostMapping("/{boardId}/edit")
    public String edit(@PathVariable("boardId") Long boardId, @ModelAttribute Board board){
        boardRepository.update(boardId, board);
        return "redirect:/basic/boards/{boardId}";
    }

    @PostMapping("/{boardId}/delete")
    public String delete(@PathVariable("boardId") Long boardId, @ModelAttribute Board board){
        boardRepository.delete(boardId);
        return "redirect:/basic/boards";
    }
}
