package menumaker.service.ingredients;

import menumaker.domain.ingredients.Fish;
import menumaker.domain.ingredients.FishType;
import menumaker.web.ingredients.dto.FishDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FishMapperTest {

    @Autowired
    private FishMapper fishMapper;

    @Test
    public void givenFishWithAllFields_shouldMapCorrect() {
        Fish sourceObject = new Fish.Builder().withName("Tonijn").withFishType(FishType.HALF_VET).withId(1L).build();
        FishDto target = fishMapper.fishToDto(sourceObject);
        assertThat(target).isNotNull();
        assertThat(target.getType()).isEqualTo("HALF_VET");

    }

}