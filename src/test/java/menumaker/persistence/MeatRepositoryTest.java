package menumaker.persistence;

import menumaker.domain.ingredients.Meat;
import menumaker.persistence.ingredients.MeatRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class MeatRepositoryTest {

    @Autowired
    private MeatRepository meatRepository;

    @Test
    public void givenCorrectIdShouldReturnCorrectMeat() {
        Optional<Meat> foundOne = meatRepository.findById(1L);
        assertThat(foundOne.get()).isNotNull();
        assertThat(foundOne.get().getId()).isEqualTo(1L);
    }

    @Test
    public void givenMeatWithoutIdShouldBeSaved() {
        Meat meat = new Meat.Builder().withName("Zwarte pens").withType("ROOD").build();
        assertThat(meat.getId()).isNull();

        meat = meatRepository.save(meat);
        assertThat(meat.getId()).isNotNull();
        assertThat(meat.getId()).isEqualTo(4L);
    }

    @Test
    public void givenCorrectIdToBeDeletedShouldDelete() {
        int total = meatRepository.findAll().size();
        meatRepository.deleteById(1L);
        assertThat(meatRepository.findAll().size()).isEqualTo(total-1);
    }

    @Test
    public void givenWrongIdToBeDeletedShouldDoNothing() {
        int total = meatRepository.findAll().size();
        meatRepository.deleteById(101L);
        assertThat(meatRepository.findAll().size()).isEqualTo(total);
    }
}