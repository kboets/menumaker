package menumaker.web.ingredients;

import menumaker.MenumakerApplication;
import menumaker.domain.ingredients.Vegetable;
import menumaker.domain.ingredients.VegetableFamilyType;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MenumakerApplication.class)
public class VegetableResourceIntegrationTest {

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

    @Test
    public void whenGetVegetableByType_shouldReturnMapWithTypes() {
        Map<String, List<VegetableDto>> result = restTemplate.getForObject(getRootUrl()+"/vegetableByType", HashMap.class);
        assertThat(!result.entrySet().isEmpty());
    }

    @Test
    public void whenCreateVegetable_shouldReturnHttpStatusCreated() {
        VegetableDto toBeCreated = vegetableMapper.vegetableToDto(new Vegetable.Builder().withName("Rode kool").withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).build());
        assertThat(toBeCreated.getVegetableId()).isNull();

        ResponseEntity<VegetableDto> response = restTemplate.postForEntity("/vegetable", toBeCreated, VegetableDto.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void whenUpdateVegetable_shouldReturnCorrectDto_afterUpdateVegetable() {
        Long id = 4002L;
        VegetableDto vegetableDto = restTemplate.getForObject(getRootUrl()+ "/vegetable/"+id, VegetableDto.class);
        assertThat(vegetableDto.getInfo()).isNull();
        vegetableDto.setInfo("Info");
        restTemplate.put("/vegetable", vegetableDto, VegetableDto.class);
        vegetableDto = restTemplate.getForObject(getRootUrl()+ "/vegetable/"+id, VegetableDto.class);
        assertThat(vegetableDto.getInfo()).isNotEmpty();
    }

    @Test
    public void whenDeleteVegetable_shouldNotFindDeleted_afterUpdateVegetable() {
        Long id = 4012L;
        VegetableDto vegetableDto = restTemplate.getForObject(getRootUrl()+ "/vegetable/"+id, VegetableDto.class);
        assertThat(vegetableDto).isNotNull();
        restTemplate.delete(getRootUrl()+ "/vegetable/"+id);
    }




}
