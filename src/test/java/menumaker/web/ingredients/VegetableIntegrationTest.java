package menumaker.web.ingredients;

import menumaker.MenumakerApplication;
import menumaker.exception.IngredientNotFoundException;
import menumaker.service.ingredients.VegetableMapper;
import menumaker.web.ingredients.dto.MeatDto;
import menumaker.web.ingredients.dto.VegetableDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MenumakerApplication.class)
public class VegetableIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private VegetableMapper vegetableMapper;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void givenKnownId_whenGetVegetable_shouldReturnVegetableDto()  {
        //4002
        Long id = 4002L;
        VegetableDto vegetableDto = restTemplate.getForObject(getRootUrl()+ "/vegetable/"+id, VegetableDto.class);
        assertNotNull(vegetableDto);
        assertThat(vegetableDto.getVegetableId()).isEqualTo(id.toString());
    }

    @Test
    public void givenUnknownId_whenGetVegetable_shouldReturnEmptyValue() {
        Long id = 1456654L;
        VegetableDto dto = restTemplate.getForObject(getRootUrl() + "/vegetable/" + id, VegetableDto.class);
        assertThat(dto).isNotNull();
    }



}
