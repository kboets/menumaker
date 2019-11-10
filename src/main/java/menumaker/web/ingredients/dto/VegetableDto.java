package menumaker.web.ingredients.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class VegetableDto {

    private String vegetableId;
    @NotNull
    @Size(min = 2, message = "Name should at least have a size of 2")
    private String name;
    private String type;
    private String info;
    private String imageUrl;

    public VegetableDto() {
    }

    private VegetableDto(Builder builder) {
        setVegetableId(builder.vegetableId);
        setName(builder.name);
        setType(builder.type);
        setImageUrl(builder.imageUrl);

    }

    public String getVegetableId() {
        return vegetableId;
    }

    public VegetableDto setVegetableId(String vegetableId) {
        this.vegetableId = vegetableId;
        return this;
    }

    public String getName() {
        return name;
    }

    public VegetableDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public VegetableDto setType(String type) {
        this.type = type;
        return this;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static final class Builder {
        private String vegetableId;
        private String name;
        private String type;
        private String imageUrl;
        private String info;

        public Builder() {
        }

        public Builder withVegetableId(String val) {
            vegetableId = val;
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

        public Builder withImageUrl(String val) {
            imageUrl = val;
            return this;
        }

        public Builder withInfo(String val) {
            info = val;
            return this;
        }

        public String getVegetableId() {
            return vegetableId;
        }

        public void setVegetableId(String vegetableId) {
            this.vegetableId = vegetableId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public VegetableDto build() {
            return new VegetableDto(this);
        }
    }
}
