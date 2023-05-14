package homework.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity

@Table(name = "albums")
@NamedQueries({
        @NamedQuery(name = "Album.findAll",
                query = "select e from Album e order by e.name"),
})
public class Album implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;
    @OneToMany
    @JoinTable(name="genres", joinColumns = @JoinColumn(name="id_album"),inverseJoinColumns=@JoinColumn(name="id_genre"))
    private List<Genre> genres = new LinkedList<>();


    @Column(name = "name")
    private String name;
    //constructors, getters, setters, toString
    public Album(String name) {

        this.name = name;
    }

    public Album() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




}
