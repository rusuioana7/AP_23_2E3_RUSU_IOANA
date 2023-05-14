package homework.entities;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll",
                query = "select e from Genre e order by e.name"),
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")
    private Integer id;


    @Column(name = "name")
    private String name;

    //constructors, getters, setters, toString
    public Genre(String name) {

        this.name = name;
    }

    public Genre() {

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
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
