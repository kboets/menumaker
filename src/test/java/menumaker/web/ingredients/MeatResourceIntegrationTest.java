package menumaker.web.ingredients;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import menumaker.MenumakerApplication;
import menumaker.domain.Meat;
import menumaker.service.ingredients.MeatMapper;
import menumaker.web.ingredients.dto.MeatDto;
import menumaker.web.ingredients.dto.MeatOriginDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MenumakerApplication.class)
public class MeatResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MeatMapper meatMapper;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }


    @Test
    public void givenGetAllMeat_shouldReturnNonEmptyList() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/meat",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        List<MeatDto> meats = mapper.readValue(response.getBody(), new TypeReference<List<MeatDto>>(){});
        assertThat(meats.size()).isEqualTo(5);
        MeatDto one = meats.get(0);
        assertThat(one.getMeatId()).isEqualTo(201L);
    }

    @Test
    public void givenMeatWithKnownId_shouldReturnCorrectMeat()  {
        Long id = 201L;
        MeatDto meat = restTemplate.getForObject(getRootUrl()+ "/meat/"+id, MeatDto.class);
        assertNotNull(meat);
        assertThat(meat.getMeatId()).isEqualTo(id);
    }

    @Test
    public void givenMeatWithUnKnownId_whenGetMeat_shouldReturnEmptyValue()  {
        Long id = 35L;
        MeatDto meat = restTemplate.getForObject(getRootUrl()+ "/meat/"+id, MeatDto.class);
        assertNotNull(meat);
        assertThat(meat.getMeatId()).isNull();
    }

    @Test
    public void givenMeat_whenCreateMeat_shouldReturnStatusCreated() {
        Meat newMeat = new Meat.Builder().withName("Steak").withType("ROOD").build();
        ResponseEntity<MeatDto> responseEntity = restTemplate.postForEntity(getRootUrl()+"/meat", meatMapper.meatToMeatDto(newMeat), MeatDto.class);
        assertNotNull(responseEntity);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void givenKnownId_whenDeleteMeat_shouldDelete() {
        Long id = 203L;
        MeatDto meat = restTemplate.getForObject(getRootUrl()+ "/meat/"+id, MeatDto.class);
        assertNotNull(meat);
        restTemplate.delete(getRootUrl()+ "/meat/"+id, MeatDto.class);
        try {
            restTemplate.getForObject(getRootUrl() + "/meat/" + id, MeatDto.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void givenKnownId_whenRetrievingMeatOrigins_shouldReturnCorrectOrigin() throws Exception{
        Long id = 201L;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/meat/"+id+"/meatorigins",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        List<MeatOriginDto> meatOriginDtos = mapper.readValue(response.getBody(), new TypeReference<List<MeatOriginDto>>(){});
        assertThat(meatOriginDtos.size()).isEqualTo(2);
        MeatOriginDto one = meatOriginDtos.get(0);
        assertThat(one.getMeatOriginId()).isEqualTo("100");
    }

}
