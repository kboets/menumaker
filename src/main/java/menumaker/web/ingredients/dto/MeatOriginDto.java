package menumaker.web.ingredients.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

public class MeatOriginDto {

    private String meatOriginId;
    private String animal;
    @JsonIgnore
    private List<MeatDto> meatDtos;

    public MeatOriginDto() {
    }

    private MeatOriginDto(Builder builder) {
        setMeatOriginId(builder.meatOriginId);
        setAnimal(builder.animal);
        setMeatDtos(builder.meatDtos);
    }

    public String getMeatOriginId() {
        return meatOriginId;
    }

    public MeatOriginDto setMeatOriginId(String meatOriginId) {
        this.meatOriginId = meatOriginId;
        return this;
    }

    public String getAnimal() {
        return animal;
    }

    public MeatOriginDto setAnimal(String animal) {
        this.animal = animal;
        return this;
    }


    public List<MeatDto> getMeatDtos() {
        return meatDtos;
    }

    public MeatOriginDto setMeatDtos(List<MeatDto> meatDtos) {
        this.meatDtos = meatDtos;
        return this;
    }


    public static final class Builder {
        private String meatOriginId;
        private String animal;
        private List<MeatDto> meatDtos;

        public Builder() {
        }

        public Builder withMeatOriginId(String val) {
            meatOriginId = val;
            return this;
        }

        public Builder withAnimal(String val) {
            animal = val;
            return this;
        }

        public Builder withMeatDtos(List<MeatDto> val) {
            meatDtos = val;
            return this;
        }

        public MeatOriginDto build() {
            return new MeatOriginDto(this);
        }
    }
}
