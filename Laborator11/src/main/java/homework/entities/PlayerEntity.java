package homework.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "players", schema = "public")
public class PlayerEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = true, length = 50)
    private String name;

    public PlayerEntity() {
    }
}


