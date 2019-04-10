package menumaker.service.ingredients;

import menumaker.domain.ingredients.MeatOrigin;
import menumaker.web.ingredients.dto.MeatOriginDto;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import static org.assertj.core.api.Assertions.assertThat;

public class MeatOriginMapperTest {

    private MeatOriginMapper meatOriginMapper;

    @Before
    public void setUp() {
        meatOriginMapper = Mappers.getMapper(MeatOriginMapper.class);
    }

    @Test
    public void givenMeatOriginWithAllFields_shouldMapCorrectToDto() {
        MeatOrigin sourceObject = new MeatOrigin.Builder().withId(1L).withAnimal("varken").build();
        MeatOriginDto targetObject = meatOriginMapper.meatOriginToDto(sourceObject);
        assertThat(targetObject.getAnimal()).isEqualTo("varken");
    }

}