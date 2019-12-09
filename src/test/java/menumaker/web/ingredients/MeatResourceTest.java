package menumaker.web.ingredients;

import com.fasterxml.jackson.databind.ObjectMapper;
import menumaker.domain.ingredients.Meat;
import menumaker.service.ingredients.MeatMapper;
import menumaker.service.ingredients.MeatService;
import menumaker.web.ingredients.dto.MeatDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MeatResource.class)
public class MeatResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MeatService meatService;


    private MeatMapper meatMapper;

    @Before
    public void init() {
        meatMapper = Mappers.getMapper(MeatMapper.class);
    }

    @Test
    public void givenOneMeat_whenRequestAllMeat_thenReturnJsonArray() throws Exception {
        //given
        List<MeatDto> meatDtos = new ArrayList<>();
        meatDtos.add(meatMapper.meatToMeatDto(new Meat.Builder().withId(1L).withType("ROOD").withName("BIEFSTUK").build()));
        given(meatService.findAllMeat()).willReturn(meatDtos);

        mvc.perform(get("/meat")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("BIEFSTUK"))

        );
    }

    @Test
    public void givenKnownMeatId_whenRequestMeat_thenReturnSingleJson() throws Exception {
        //given
        Optional<MeatDto> meatOptional = Optional.of(meatMapper.meatToMeatDto(new Meat.Builder().withId(1L).withType("ROOD").withName("BIEFSTUK").build()));


        given(meatService.getMeatById(1L)).willReturn(meatOptional);

        mvc.perform(get("/meat/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.meatId", is(1)))
                .andExpect(jsonPath("$.name", is("BIEFSTUK"))
                );
        verify(meatService, times(1)).getMeatById(1L);
        verifyNoMoreInteractions(meatService);
    }

    @Test
    public void givenUnknownMeatId_whenRequestMeat_thenReturnStatusNotFound() throws Exception {
        //given
        Optional<MeatDto> meatOptional = Optional.ofNullable(null);

        given(meatService.getMeatById(1L)).willReturn(meatOptional);

        mvc.perform(get("/meat/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        verify(meatService, times(1)).getMeatById(1L);
        verifyNoMoreInteractions(meatService);
    }


    @Test
    public void givenOneMeat_whenRequestCreateMeat_thenReturnStatusCreated() throws Exception {
        MeatDto meatNoId =  meatMapper.meatToMeatDto(new Meat.Builder().withType("ROOD").withName("BIEFSTUK").build());
        MeatDto meatDto =  meatMapper.meatToMeatDto(new Meat.Builder().withId(1L).withType("ROOD").withName("BIEFSTUK").build());

        given(meatService.saveMeat(ArgumentMatchers.any())).willReturn(meatDto);

        mvc.perform(post("/meat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(meatNoId)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location",  containsString("http://localhost/meat/1")));

    }

    @Test
    public void givenKnownMeatId_whenRequestDeleteMeat_thenReturnTrue() throws Exception {
        given(meatService.deleteMeat(1L)).willReturn(Boolean.TRUE);
        mvc.perform(delete("/meat/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(meatService, times(1)).deleteMeat(1L);
        verifyNoMoreInteractions(meatService);
    }

    @Test
    public void givenUnKnownMeatId_whenRequestDeleteMeat_thenReturnStatusNotFound() throws Exception {
        given(meatService.deleteMeat(1L)).willReturn(Boolean.FALSE);
        mvc.perform(delete("/meat/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
        verify(meatService, times(1)).deleteMeat(1L);
        verifyNoMoreInteractions(meatService);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}