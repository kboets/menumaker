package menumaker.domain.ingredients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "POTATO")
public class Potato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="POTATO_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name="POTATO_TYPE", nullable=false)
    @Enumerated(EnumType.STRING)
    private PotatoType potatoType;

    public Potato() {
    }

    public Long getId() {
        return id;
    }

    public Potato setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Potato setName(String name) {
        this.name = name;
        return this;
    }

    public PotatoType getPotatoType() {
        return potatoType;
    }

    public Potato setPotatoType(PotatoType potatoType) {
        this.potatoType = potatoType;
        return this;
    }

    private Potato(Builder builder) {
        id = builder.id;
        name = builder.name;
        potatoType = builder.potatoType;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private PotatoType potatoType;

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

        public Builder withPotatoType(PotatoType val) {
            potatoType = val;
            return this;
        }

        public Potato build() {
            return new Potato(this);
        }
    }
}
