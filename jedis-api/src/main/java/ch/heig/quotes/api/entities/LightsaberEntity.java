package ch.heig.quotes.api.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "LightSaber")
@Table(name = "lightsabers")
public class LightsaberEntity {
    @TableGenerator(name = "genLightsabers",
            table = "idLightsabers",
            pkColumnName = "name",
            valueColumnName = "val",
            initialValue = 3,
            allocationSize = 100)
    @Id // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "genLightsabers")
    private int id;
    private String color;


    @ManyToMany(mappedBy = "likedLightsabers")
    Set<JediEntity> likedByJedis;


    public LightsaberEntity() {}

    public LightsaberEntity(int id, String color) {
        this.id = id;
        this.color = color;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
