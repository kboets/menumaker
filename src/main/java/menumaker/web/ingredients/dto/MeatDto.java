package menumaker.web.ingredients.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeatDto {

    private Long meatId;
    @NotNull
    @Size(min = 2, message = "Name should at least have a size of 2")
    private String name;
    @NotNull
    @Size(min = 2, message = "type should at least have a size of 2")
    private String type;

    public MeatDto() {
    }

    private MeatDto(Builder builder) {
        setMeatId(builder.meatId);
        setName(builder.name);
        setType(builder.type);
    }

    public Long getMeatId() {
        return meatId;
    }

    public MeatDto setMeatId(Long meatId) {
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

    public static final class Builder {
        private Long meatId;
        private @NotNull @Size(min = 2, message = "Name should at least have a size of 2") String name;
        private @NotNull @Size(min = 2, message = "type should at least have a size of 2") String type;

        public Builder() {
        }

        public Builder withMeatId(Long val) {
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

        public MeatDto build() {
            return new MeatDto(this);
        }
    }
}
