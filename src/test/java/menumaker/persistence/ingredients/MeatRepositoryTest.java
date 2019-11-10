package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Meat;
import menumaker.persistence.ingredients.MeatRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
@Transactional()
public class MeatRepositoryTest {

    @Autowired
    private MeatRepository meatRepository;

    @Test
    public void givenCorrectIdShouldReturnCorrectMeat() {
        Optional<Meat> foundOne = meatRepository.findById(202L);
        assertThat(foundOne.get()).isNotNull();
        assertThat(foundOne.get().getId()).isEqualTo(202L);
        assertThat(foundOne.get().getName().equals("Kipfilet"));
    }

    @Test
    public void givenMeatWithoutIdShouldBeSaved() {
        Meat meat = new Meat.Builder().withName("Zwarte pens").withType("ROOD").build();
        assertThat(meat.getId()).isNull();

        meat = meatRepository.save(meat);
        assertThat(meat.getId()).isNotNull();
        //assertThat(meat.getId()).isEqualTo(4L);
    }

    @Test
    public void givenCorrectIdToBeDeletedShouldDelete() {
        int total = meatRepository.findAll().size();
        meatRepository.deleteById(203L);
        assertThat(meatRepository.findAll().size()).isEqualTo(total-1);
    }

}