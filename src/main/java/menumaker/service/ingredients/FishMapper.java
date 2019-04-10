package menumaker.service.ingredients;

import menumaker.domain.ingredients.Fish;
import menumaker.domain.ingredients.Meat;
import menumaker.web.ingredients.dto.FishDto;
import menumaker.web.ingredients.dto.MeatDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FishMapper {



    @Mappings({
            @Mapping(target = "fishId", source = "id"),
            @Mapping(target = "type", source = "fishType")
    })
    FishDto fishToDto(Fish fish);

    List<FishDto> fishListToDtos(List<Fish> meats);

    @InheritInverseConfiguration
    Fish dtoToFish(FishDto fishDto);
}
