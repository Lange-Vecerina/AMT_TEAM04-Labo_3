package ch.heig.quotes.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Set;


/**
 * @author Yanik Lange, Ivan Vecerina
 */
@Entity(name = "Jedi")
@Table(name = "jedis")
public class JediEntity {
@TableGenerator(name = "genJedis",
            table = "idJedis",
            pkColumnName = "id",
            valueColumnName = "val",
            initialValue = 7,
            allocationSize = 100)
    @Id // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "genJedis")
    private int id;
    @NotNull
    private String name;
    private String rank;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "jedi_lightsaber",
            joinColumns = @JoinColumn(name = "jedi_id"),
            inverseJoinColumns = @JoinColumn(name = "lightsaber_id")
    )
    Set<LightsaberEntity> lightsabers;

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
        if(name == null || name.isEmpty()) {
            this.name = null;
        } else {
            this.name = name;
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Set<LightsaberEntity> getLightsabers() {
        return lightsabers;
    }

    /*public void setLightsabers(Set<LightsaberEntity> lightsabers) {
        this.lightsabers = lightsabers;
    }

    public void setRelationWithLightsaber(LightsaberEntity lightsaber) {
        this.lightsabers.add(lightsaber);
    }*/

}
