package menumaker.persistence;

import menumaker.domain.Fish;
import menumaker.domain.FishType;
import menumaker.persistence.ingredients.FishRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FishRepositoryTest {

    @Autowired
    private FishRepository fishRepository;

    @Test
    public void givenCorrectName_shouldReturnFish() {
        Fish fish = fishRepository.findByName("Tonijn");
        assertThat(fish).isNotNull();
        assertThat(fish.getFishType()).isEqualTo(FishType.HALF_FAT);
    }

    @Test
    public void givenInCorrectName_shouldReturnNoFish() {
        Fish fish = fishRepository.findByName("TOnijn");
        assertThat(fish).isNull();
    }
}
