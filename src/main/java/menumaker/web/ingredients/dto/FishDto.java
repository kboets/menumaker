package menumaker.web.ingredients.dto;

public class FishDto extends BaseDto{

    private String fishId;
    private String name;
    private String type;

    public FishDto() {
    }

    private FishDto(Builder builder) {
        setFishId(builder.fishId);
        setName(builder.name);
        setType(builder.type);
    }

    public String getFishId() {
        return fishId;
    }

    public FishDto setFishId(String fishId) {
        this.fishId = fishId;
        return this;
    }

    public String getName() {
        return name;
    }

    public FishDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public FishDto setType(String type) {
        this.type = type;
        return this;
    }


    public static final class Builder {
        private String fishId;
        private String name;
        private String type;

        public Builder() {
        }

        public Builder withFishId(String val) {
            fishId = val;
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

        public FishDto build() {
            return new FishDto(this);
        }
    }
}
