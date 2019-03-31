package menumaker.service.ingredients;

import menumaker.domain.Meat;
import menumaker.web.ingredients.dto.MeatDto;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MeatMapperTest {

    private MeatMapper meatMapper;

    @Before
    public void setUp() {
        meatMapper = Mappers.getMapper(MeatMapper.class);
    }

    @Test
    public void givenMeatWithAllFields_shouldMapCorrectToDto() {
        Meat sourceObject = new Meat.Builder().withId(1L).withName("Kippeworst").withType("WIT").build();
        MeatDto targetObject = meatMapper.meatToMeatDto(sourceObject);
        assertThat(targetObject.getName()).isEqualTo("Kippeworst");
        assertThat(targetObject.getMeatId()).isEqualTo(1L);
    }

    @Test
    public void givenListMeat_shouldMapCorrectToListDto() {
        List<Meat> meatList = new ArrayList<>();
        meatList.add(new Meat.Builder().withId(1L).withName("Spek").withType("ROOD").build());
        meatList.add(new Meat.Builder().withId(2L).withName("Kippeworst").withType("WIT").build());

        List<MeatDto> dtos =  meatMapper.meatsToMeatDtos(meatList);

        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos.get(0).getMeatId()).isEqualTo(1L);

    }

    @Test
    public void givenMeatDtoWitAllFields_shouldMapToMeat() {
        MeatDto sourceObject = new MeatDto.Builder().withMeatId(1L).withName("Kippeworst").withType("WIT").build();
        Meat targetObject = meatMapper.dtoToMeat(sourceObject);
        assertThat(targetObject.getName()).isEqualTo("Kippeworst");
        assertThat(targetObject.getId()).isEqualTo(1L);
    }

    @Test
    public void givenMeatNotAllFields_shouldMapCorrect() {
        Meat sourceObject = new Meat.Builder().withId(1L).withName("Kippeworst").build();
        MeatDto targetObject = meatMapper.meatToMeatDto(sourceObject);
        assertThat(targetObject.getName()).isEqualTo("Kippeworst");
    }
}