package menumaker.domain.ingredients;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "VEGETABLE")
public class Vegetable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEGETABLE_ID")
    private Long id;

    @Column
    private String name;

    @Column(name="VEGETABLE_TYPE", nullable=false)
    @Enumerated(EnumType.STRING)
    private VegetableFamilyType vegetableFamilyType;

    public Vegetable() {
    }

    private Vegetable(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setVegetableFamilyType(builder.vegetableFamilyType);
    }

    public Long getId() {
        return id;
    }

    public Vegetable setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Vegetable setName(String name) {
        this.name = name;
        return this;
    }

    public VegetableFamilyType getVegetableFamilyType() {
        return vegetableFamilyType;
    }

    public Vegetable setVegetableFamilyType(VegetableFamilyType vegetableFamilyType) {
        this.vegetableFamilyType = vegetableFamilyType;
        return this;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private VegetableFamilyType vegetableFamilyType;

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

        public Builder withVegetableFamilyType(VegetableFamilyType val) {
            vegetableFamilyType = val;
            return this;
        }

        public Vegetable build() {
            return new Vegetable(this);
        }
    }
}
