package menumaker.domain.ingredients;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "MEAT_ORIGIN")
public class MeatOrigin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEAT_ORIGIN_ID")
    private Long id;

    @Column(nullable = false)
    private String animal;

    @ManyToMany(mappedBy = "meatOrigins")
    private List<Meat> meats;

    public MeatOrigin() {
    }

    private MeatOrigin(Builder builder) {
        setId(builder.id);
        setAnimal(builder.animal);
        setMeats(builder.meats);
    }

    public Long getId() {
        return id;
    }

    public MeatOrigin setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAnimal() {
        return animal;
    }

    public MeatOrigin setAnimal(String animal) {
        this.animal = animal;
        return this;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public MeatOrigin setMeats(List<Meat> meats) {
        this.meats = meats;
        return this;
    }

    public static final class Builder {
        private Long id;
        private String animal;
        private List<Meat> meats;
        private Set<Meat> meatSet;

        public Builder() {
        }

        public Builder withId(Long val) {
            id = val;
            return this;
        }

        public Builder withAnimal(String val) {
            animal = val;
            return this;
        }

        public Builder withMeats(List<Meat> val) {
            meats = val;
            return this;
        }

        public Builder withMeatSet(Set<Meat> val) {
            meatSet = val;
            return this;
        }

        public MeatOrigin build() {
            return new MeatOrigin(this);
        }
    }
}
