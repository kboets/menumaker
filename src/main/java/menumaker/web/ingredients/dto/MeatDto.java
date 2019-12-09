package menumaker.web.ingredients.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

public class MeatDto {

    private String meatId;
    @NotNull
    @Size(min = 2, message = "Name should at least have a size of 2")
    private String name;
    @NotNull
    @Size(min = 2, message = "type should at least have a size of 2")
    private String type;
    private String imageUrl;
    private List<MeatOriginDto> meatOriginDtos;

    public MeatDto() {
    }

    private MeatDto(Builder builder) {
        setMeatId(builder.meatId);
        setName(builder.name);
        setType(builder.type);
        setMeatOriginDtos(builder.meatOriginDtos);
        setImageUrl(builder.imageUrl);
    }

    public String getMeatId() {
        return meatId;
    }

    public MeatDto setMeatId(String meatId) {
        this.meatId = meatId;
        return this;
    }

    public String getName() {
        return name;
    }

    public MeatDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public MeatDto setType(String type) {
        this.type = type;
        return this;
    }

    public List<MeatOriginDto> getMeatOriginDtos() {
        return meatOriginDtos;
    }

    public MeatDto setMeatOriginDtos(List<MeatOriginDto> meatOriginDtos) {
        this.meatOriginDtos = meatOriginDtos;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static final class Builder {
        private String meatId;
        private @NotNull @Size(min = 2, message = "Name should at least have a size of 2") String name;
        private @NotNull @Size(min = 2, message = "type should at least have a size of 2") String type;
        private String imageUrl;
        private List<MeatOriginDto> meatOriginDtos;

        public Builder() {
        }

        public Builder withMeatId(String val) {
            meatId = val;
            return this;
        }

        public Builder withName(@NotNull @Size(min = 2, message = "Name should at least have a size of 2") String val) {
            name = val;
            return this;
        }

        public Builder withType(@NotNull @Size(min = 2, message = "type should at least have a size of 2") String val) {
            type = val;
            return this;
        }

        public Builder withMeatOriginDtos(List<MeatOriginDto> val) {
            meatOriginDtos = val;
            return this;
        }

        public Builder withImageUrl(String val) {
            imageUrl = val;
            return this;
        }

        public MeatDto build() {
            return new MeatDto(this);
        }
    }
}
