package hello.crudboard.domain.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Board {
    private Long id;
    private String title;
    private String contents;
    private String password;
    private String name;
    private String date;
    private int views;

    public Board(){
    }

    public Board(Long id, String title, String contents, String password, String name, String date, int views) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.name = name;
        this.date = date;
        this.views = views;
    }
}

