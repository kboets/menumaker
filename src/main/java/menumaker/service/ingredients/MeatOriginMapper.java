package menumaker.service.ingredients;

import menumaker.domain.MeatOrigin;
import menumaker.web.ingredients.dto.MeatOriginDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MeatOriginMapper {

    @Mapping(target = "meatOriginId", source = "id")
    MeatOriginDto meatOriginToDto(MeatOrigin meatOrigin);

    @InheritInverseConfiguration
    MeatOrigin dtoToMeatOrigin(MeatOriginDto meatOriginDto);

}
