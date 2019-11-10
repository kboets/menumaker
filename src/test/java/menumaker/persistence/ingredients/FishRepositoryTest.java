package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Fish;
import menumaker.domain.ingredients.FishType;
import menumaker.persistence.ingredients.FishRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

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
        assertThat(fish.getFishType()).isEqualTo(FishType.HALF_VET);
    }

    @Test
    public void givenInCorrectName_shouldReturnNoFish() {
        Fish fish = fishRepository.findByName("TOnijn");
        assertThat(fish).isNull();
    }

    @Test
    public void givenPersistedFish_whenUpdate_shouldNotBeAddedAgain() {
        Fish fish = new Fish.Builder().withId(3001L).withName("Tonijn steak").build();
        fishRepository.save(fish);
        Optional<Fish> fishOptional = fishRepository.findById(3001L);
        assertThat(fishOptional.isPresent()).isTrue();
        assertThat(fishOptional.get().getName()).isEqualTo("Tonijn steak");
    }
}
