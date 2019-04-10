package menumaker.domain.ingredients;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FISH")
public class Fish implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="FISH_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name="FISH_TYPE", nullable=false)
    @Enumerated(EnumType.STRING)
    private FishType fishType;

    public Fish() {
    }

    private Fish(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setFishType(builder.fishType);
    }


    public Long getId() {
        return id;
    }

    public Fish setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Fish setName(String name) {
        this.name = name;
        return this;
    }

    public FishType getFishType() {
        return fishType;
    }

    public Fish setFishType(FishType fishType) {
        this.fishType = fishType;
        return this;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private FishType fishType;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withFishType(FishType val) {
            fishType = val;
            return this;
        }

        public Fish build() {
            return new Fish(this);
        }
    }
}
