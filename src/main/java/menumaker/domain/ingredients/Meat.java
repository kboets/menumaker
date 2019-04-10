package menumaker.domain.ingredients;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "MEAT")
public class Meat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEAT_ID")
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @ManyToMany
    @JoinTable(name="MEAT_MEATORIGINS",
            joinColumns=@JoinColumn(name="MEAT_ID"),
            inverseJoinColumns=@JoinColumn(name="MEAT_ORIGIN_ID"))
    private List<MeatOrigin> meatOrigins;


    public Meat() {
    }

    private Meat(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setType(builder.type);
        setMeatOrigins(builder.meatOrigins);
    }

    public Long getId() {
        return id;
    }

    public Meat setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Meat setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Meat setType(String type) {
        this.type = type;
        return this;
    }

    public List<MeatOrigin> getMeatOrigins() {
        return meatOrigins;
    }

    public Meat setMeatOrigins(List<MeatOrigin> meatOrigins) {
        this.meatOrigins = meatOrigins;
        return this;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String type;
        private List<MeatOrigin> meatOrigins;

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

        public Builder withType(String val) {
            type = val;
            return this;
        }

        public Builder withMeatOrigins(List<MeatOrigin> val) {
            meatOrigins = val;
            return this;
        }

        public Meat build() {
            return new Meat(this);
        }
    }
}
