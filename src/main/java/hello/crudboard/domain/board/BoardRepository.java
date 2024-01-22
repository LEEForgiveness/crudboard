package hello.crudboard.domain.board;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class BoardRepository {

    private static final Map<Long, Board> bulletin_board = new HashMap<>();
    private static long sequence = 0L;

    private int view = 0;

    public String nowDate(){
        Date nowday = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        String strDate = simpleDateFormat.format(nowday);
        return strDate;
    }

    public Board save(Board board){
        board.setId(++sequence);
        board.setDate(nowDate());
        board.setViews(view);
        bulletin_board.put(board.getId(), board);
        return board;
    }

    public Board findById(Long id){
        return bulletin_board.get(id);
    }

    public List<Board> findAll(){
        return new ArrayList<>(bulletin_board.values());
    }

    public void update(Long boardId, Board updateParam){
        Board findBoard = findById(boardId);
        findBoard.setTitle(updateParam.getTitle());
        findBoard.setContents(updateParam.getContents());
    }

    public void delete(Long id){
        bulletin_board.remove(id);
    }

    public void clearboard(){
        bulletin_board.clear();
    }

}
