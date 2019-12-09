package menumaker.service.ingredients;

import menumaker.domain.ingredients.Meat;
import menumaker.domain.ingredients.MeatOrigin;
import menumaker.web.ingredients.dto.MeatDto;
import menumaker.web.ingredients.dto.MeatOriginDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MeatMapperTest {

    @Autowired
    private MeatMapper meatMapper;

    @Test
    public void givenMeatWithAllFields_shouldMapCorrectToDto() {
        Meat sourceObject = new Meat.Builder().withId(1L).withName("Kippeworst").withType("WIT").build();
        MeatDto targetObject = meatMapper.meatToMeatDto(sourceObject);
        assertThat(targetObject.getName()).isEqualTo("Kippeworst");
        assertThat(targetObject.getMeatId()).isEqualTo("1");
    }

    @Test
    public void givenListMeat_shouldMapCorrectToListDto() {
        List<Meat> meatList = new ArrayList<>();
        meatList.add(new Meat.Builder().withId(1L).withName("Spek").withType("ROOD").build());
        meatList.add(new Meat.Builder().withId(2L).withName("Kippeworst").withType("WIT").build());

        List<MeatDto> dtos =  meatMapper.meatsToMeatDtos(meatList);

        assertThat(dtos.size()).isEqualTo(2);
        assertThat(dtos.get(0).getMeatId()).isEqualTo("1");

    }

    @Test
    public void givenMeatDtoWitAllFields_shouldMapToMeat() {
        MeatDto sourceObject = new MeatDto.Builder().withMeatId("1").withName("Kippeworst").withType("WIT").build();
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

    @Test
    public void givenMeatWithMeatOrigins_shouldMapAllFields() {
        List<MeatOrigin> meatOriginSet = new ArrayList<>();
        meatOriginSet.add(new MeatOrigin.Builder().withAnimal("varken").build());
        Meat sourceObject = new Meat.Builder().withId(1L).withType("ROOD").withName("spek").withMeatOrigins(meatOriginSet).build();
        MeatDto targetObject = meatMapper.meatToMeatDto(sourceObject);
        assertThat(targetObject.getName()).isEqualTo("spek");
        List<MeatOriginDto> meatOriginDtos = targetObject.getMeatOriginDtos();
        assertThat(meatOriginDtos).hasSize(1);
    }


}