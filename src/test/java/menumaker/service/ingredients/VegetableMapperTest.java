package menumaker.service.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.domain.ingredients.VegetableFamilyType;
import menumaker.web.ingredients.dto.VegetableDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VegetableMapperTest {

    @Autowired
    private VegetableMapper vegetableMapper;

    @Test
    public void givenVegetable_whenMapping_shouldReturnDto() {
        Vegetable vegetable = new Vegetable.Builder().withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).withId(2L).withName("Rode kool").build();
        VegetableDto vegetableDto = vegetableMapper.vegetableToDto(vegetable);
        assertThat(vegetableDto.getType()).isEqualTo("KOOLGROENTEN");
        assertThat(vegetableDto.getVegetableId()).isEqualTo("2");
    }

    @Test
    public void givenDto_whenMapping_shouldReturnVegetable() {
        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setName("Rode kool");
        vegetableDto.setType("KOOLGROENTEN");
        Vegetable vegetable = vegetableMapper.dtoToVegetable(vegetableDto);
        assertThat(vegetable.getVegetableFamilyType()).isEqualTo(VegetableFamilyType.KOOLGROENTEN);
    }
}