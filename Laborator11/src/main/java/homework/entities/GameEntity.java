package homework.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "games")
public class GameEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "grid", columnDefinition = "TEXT")
    private String grid;

    @Column(name = "player1name", columnDefinition = "TEXT")
    private String player1Name;

    @Column(name = "player1symbol", columnDefinition = "TEXT")
    private String player1Symbol;

    @Column(name = "player2name", columnDefinition = "TEXT")
    private String player2Name;

    @Column(name = "player2symbol", columnDefinition = "TEXT")
    private String player2Symbol;

    @Column(name = "duration", columnDefinition = "TEXT")
    private String duration;

    @Column(name = "game_date", columnDefinition = "DATE")
    private Date date;


    public GameEntity() {
    }

}

