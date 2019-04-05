package menumaker.service.ingredients;

import menumaker.domain.Meat;
import menumaker.web.ingredients.dto.MeatDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.ManyToMany;
import java.util.List;

@Mapper(componentModel = "spring", uses = MeatOriginMapper.class)
public interface MeatMapper {

    @Mapping(target = "meatId", source = "id")
    @Mapping(target = "meatOriginDtos", source = "meatOrigins")
    MeatDto meatToMeatDto(Meat meat);

    List<MeatDto> meatsToMeatDtos(List<Meat> meats);

    @InheritInverseConfiguration
    Meat dtoToMeat(MeatDto meatDto);
}
