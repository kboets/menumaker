package menumaker.persistence.ingredients;

import menumaker.domain.ingredients.Vegetable;
import menumaker.domain.ingredients.VegetableFamilyType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class VegetableRepositoryTest {

    @Autowired
    private VegetableRepository vegetableRepository;

    @Test
    public void givenCorrectName_whenFindByName_shouldReturnVegetable() {
        Vegetable bloemkool = vegetableRepository.findByName("Bloemkool");
        assertThat(bloemkool).isNotNull();
        assertThat(bloemkool.getVegetableFamilyType()).isEqualTo(VegetableFamilyType.CABBAGE);
    }

    @Test
    public void givenUnkownName_whenFindByName_shouldNotReturnVegetable() {
        Vegetable bloemkool = vegetableRepository.findByName("mkooll");
        assertThat(bloemkool).isNull();
    }

    @Test
    public void givenKnownVegetablesType_whenFindByVegetableFamilyType_shouldReturnAllVegetableWithType() {
        List<Vegetable> cabbages = vegetableRepository.findByVegetableFamilyType(VegetableFamilyType.CABBAGE);
        assertThat(cabbages.size()).isGreaterThan(0);
        for(Vegetable vegetable:cabbages) {
            assertThat(vegetable.getVegetableFamilyType()).isEqualTo(VegetableFamilyType.CABBAGE);
        }
    }


}