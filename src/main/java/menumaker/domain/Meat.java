package menumaker.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "MEAT")
public class Meat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String type;
    @ManyToOne
    @JoinColumn(name = "meat_meatorigin_id", referencedColumnName = "id")
    private MeatOrigin meatOrigin;


    public Meat() {

    }
    private Meat(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setType(builder.type);
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

    public MeatOrigin getMeatOrigin() {
        return meatOrigin;
    }

    public Meat setMeatOrigin(MeatOrigin meatOrigin) {
        this.meatOrigin = meatOrigin;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meat meat = (Meat) o;
        return Objects.equals(name, meat.name) &&
                Objects.equals(type, meat.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String type;

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

        public Meat build() {
            return new Meat(this);
        }
    }
}
