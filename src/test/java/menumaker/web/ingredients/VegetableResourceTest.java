package menumaker.web.ingredients;

import com.fasterxml.jackson.databind.ObjectMapper;
import menumaker.domain.ingredients.Vegetable;
import menumaker.domain.ingredients.VegetableFamilyType;
import menumaker.service.ingredients.VegetableMapper;
import menumaker.service.ingredients.VegetableService;
import menumaker.web.ingredients.dto.VegetableDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(VegetableResource.class)
public class VegetableResourceTest {


    private VegetableMapper vegetableMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VegetableService vegetableService;

    @Before
    public void init() {
        vegetableMapper = Mappers.getMapper(VegetableMapper.class);
    }

    @Test
    public void givenKnownId_whenGetById_thenReturnSingleJson() throws Exception {
        //given
        Optional<VegetableDto> optionalMeatDto = Optional.of(vegetableMapper.vegetableToDto(new Vegetable.Builder().withId(1L).withName("Bloemkool").withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).build()));

        given(vegetableService.findById(1L)).willReturn(optionalMeatDto);

        mvc.perform(get("/vegetable/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vegetableId", is("1")))
                .andExpect(jsonPath("$.name", is("Bloemkool"))
                );

        verify(vegetableService, times(1)).findById(1L);
        verifyNoMoreInteractions(vegetableService);
    }

    @Test
    public void givenUnKnownId_whenGetById_thenReturnStatusNotFound() throws Exception {
        //given
        Optional<VegetableDto> optionalMeatDto = Optional.empty();

        given(vegetableService.findById(146L)).willReturn(optionalMeatDto);

        mvc.perform(get("/vegetable/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(vegetableService, times(1)).findById(1L);
        verifyNoMoreInteractions(vegetableService);
    }

    @Test
    public void givenListOfTwoVegetables_whenGetAll_thenReturnTwoValues() throws Exception {
        List<VegetableDto> vegetableDtos = new ArrayList<>();
        vegetableDtos.add(vegetableMapper.vegetableToDto(new Vegetable.Builder().withId(1L).withName("Bloemkool").withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).build()));
        vegetableDtos.add(vegetableMapper.vegetableToDto(new Vegetable.Builder().withId(2L).withName("Wortelen").withVegetableFamilyType(VegetableFamilyType.WORTELEN).build()));

        given(vegetableService.findAllVegetables()).willReturn(vegetableDtos);

        mvc.perform(get("/vegetable")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void givenOneVegetable_whenCreateVegetable_thenReturnStatusCreated() throws Exception {
        VegetableDto toBeCreated = vegetableMapper.vegetableToDto(new Vegetable.Builder().withName("Bloemkool").withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).build());
        VegetableDto created = vegetableMapper.vegetableToDto(new Vegetable.Builder().withId(1L).withName("Bloemkool").withVegetableFamilyType(VegetableFamilyType.KOOLGROENTEN).build());

        //given
        given(vegetableService.save(any())).willReturn(created);

        MvcResult mvcResult = mvc.perform(post("/vegetable")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(toBeCreated))).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertThat(status).isEqualTo(201);
        String location = (String) mvcResult.getResponse().getHeaderValue("location");

        assertThat(location).isEqualTo("http://localhost/vegetable/1");

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}