package menumaker.service.ingredients;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class EnumMapper {

    protected String mapEnum(Enum<?> enums) {
        if(enums == null) return null;
        return enums.toString();
    }
}
