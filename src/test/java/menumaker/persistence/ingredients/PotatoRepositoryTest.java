package menumaker.persistence.ingredients;


import menumaker.domain.ingredients.Potato;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PotatoRepositoryTest {

    @Autowired
    private PotatoRepository repository;

    @Test
    public void givenCorrectName_whenFindByName_shouldReturnPotato() {
        String givenName = "patatten";
        List<Potato> potatoes = repository.findByName(givenName);
        assertThat(potatoes.size()).isEqualTo(1);
    }
}
