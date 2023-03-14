package com.crud.tasks.controler;

import com.crud.tasks.controller.TrelloController;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringJUnitConfig
@WebMvcTest(TrelloController.class)
class TrelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrelloFacade trelloFacade;

    @Test
    void shouldFetchTrelloBoards() throws Exception {
        // given
        List<TrelloBoardDto> trelloBoardDtoList = Arrays.asList(new TrelloBoardDto("test_board_id", "test_board_name", new ArrayList<>()));
        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoardDtoList);

        // when & then
        mockMvc.perform(get("/v1/trello/boards")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is("test_board_id")))
                .andExpect(jsonPath("$[0].name", is("test_board_name")));
    }

    @Test
    void shouldCreateTrelloCard() throws Exception {
        // given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_name", "test_description", "test_pos", "test_list_id");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("test_id", "test_name", "test_shortUrl");
        when(trelloFacade.createCard(any())).thenReturn(createdTrelloCardDto);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(trelloCardDto);

        // when & then
        mockMvc.perform(post("/v1/trello/cards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("test_id")))
                .andExpect(jsonPath("$.name", is("test_name")))
                .andExpect(jsonPath("$.shortUrl", is("test_shortUrl")));
    }
}