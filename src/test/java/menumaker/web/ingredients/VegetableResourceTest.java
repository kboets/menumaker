package menumaker.web.ingredients;

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

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        Optional<VegetableDto> optionalMeatDto = Optional.of(vegetableMapper.vegetableToDto(new Vegetable.Builder().withId(1L).withName("Bloemkool").withVegetableFamilyType(VegetableFamilyType.CABBAGE).build()));

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



}