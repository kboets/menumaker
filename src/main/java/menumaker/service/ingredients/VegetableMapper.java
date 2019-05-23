package menumaker.service.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.web.ingredients.dto.VegetableDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VegetableMapper {

    @Mappings({
            @Mapping(target = "vegetableId", source = "id"),
            @Mapping(target = "type", source = "vegetableFamilyType")
    })
    VegetableDto vegetableToDto(Vegetable vegetable);

    @InheritInverseConfiguration
    Vegetable dtoToVegetable(VegetableDto vegetableDto);

    List<VegetableDto> vegetableListToDtos(List<Vegetable> vegetables);
}
