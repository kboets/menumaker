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

    @Column(nullable = false)
    private String name;

    @Column
    private String imageUrl;

    @Column
    private String info;

    @Column(name="VEGETABLE_TYPE", nullable=false)
    @Enumerated(EnumType.STRING)
    private VegetableFamilyType vegetableFamilyType;

    public Vegetable() {
        setImageUrl(DomainUtil.createImageUrl(DomainUtil.vegetableUrlPrefix, this.getName()));
    }

    private Vegetable(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setVegetableFamilyType(builder.vegetableFamilyType);
        setImageUrl(builder.imageUrl);
        setInfo(builder.info);
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private VegetableFamilyType vegetableFamilyType;
        private String imageUrl;
        private String info;

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

        public Builder withImageUrl(String val) {
            imageUrl = val;
            return this;
        }

        public Builder withInfo(String val) {
            info = val;
            return this;
        }

        public Vegetable build() {
            return new Vegetable(this);
        }
    }
}
