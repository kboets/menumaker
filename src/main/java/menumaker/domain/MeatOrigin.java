package menumaker.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MEAT_ORIGIN")
public class MeatOrigin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String animal;

    @OneToMany(mappedBy = "meatOrigin", fetch = FetchType.LAZY)
    private List<Meat> meats;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeatOrigin)) return false;
        MeatOrigin that = (MeatOrigin) o;
        return Objects.equals(getAnimal(), that.getAnimal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimal());
    }
}
