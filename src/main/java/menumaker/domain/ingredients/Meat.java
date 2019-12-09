package menumaker.domain.ingredients;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "MEAT")
public class Meat implements Serializable {

    public static final String TYPE_RED = "ROOD";
    public static final String TYPE_WHITE = "WIT";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEAT_ID")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(name = "IMG_URL")
    private String imageUrl;
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
        setImageUrl(builder.imageUrl);
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Meat setMeatOrigins(List<MeatOrigin> meatOrigins) {
        this.meatOrigins = meatOrigins;
        return this;
    }

    public void initImageUrl() {
        this.setImageUrl(DomainUtil.createImageUrl(DomainUtil.meatUrlPrefix, this.getName()));
    }


    public static final class Builder {
        public static String TYPE_RED = "ROOD";
        public static String TYPE_WHITE = "WIT";
        private Long id;
        private String name;
        private String type;
        private String imageUrl;
        private List<MeatOrigin> meatOrigins;

        public Builder() {
        }

        public static Builder aMeat() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder withMeatOrigins(List<MeatOrigin> meatOrigins) {
            this.meatOrigins = meatOrigins;
            return this;
        }

        public Meat build() {
           return new Meat(this);
        }
    }
}
