package ch.heig.quotes.api.entities;



import jakarta.persistence.*;

import java.util.Set;


@Entity(name = "Jedi")
@Table(name = "jedis")
public class JediEntity {
/*@TableGenerator(name = "genJedis",
            table = "idJedis",
            pkColumnName = "name",
            valueColumnName = "val",
            initialValue = 3,
            allocationSize = 100)*/
    @Id // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "genJedis")
    private int id;
    private String name;
    private String rank;

    @ManyToMany
    @JoinTable(
            name = "jedi_lightsaber",
            joinColumns = @JoinColumn(name = "jedi_id"),
            inverseJoinColumns = @JoinColumn(name = "lightsaber_id")
    )
    Set<LightsaberEntity> likedLightsabers;

    public JediEntity() {}

    public JediEntity(int id, String name, String rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
