package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "FirstTrelloListDtos", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "SecondTrelloListDtos", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "FirstTrelloBoardDto", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "SecondTrelloBoardDto", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("1", "FirstTrelloList", true);
        TrelloList trelloList2 = new TrelloList("2", "SecondTrelloList", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        String id1 = trelloBoardDto1.getId();
        String name1 = trelloBoardDto1.getName();
        String id2 = trelloBoardDto2.getId();
        String name2 = trelloBoardDto2.getName();

        TrelloBoard trelloBoard1 = new TrelloBoard(id1, name1, trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard(id2, name2, trelloLists);
        List<TrelloBoard> testBoard = new ArrayList<>();
        testBoard.add(trelloBoard1);
        testBoard.add(trelloBoard2);

        //When
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(testBoard.get(0).getName(), resultBoard.get(0).getName());
    }

    @Test
    void testMapToBoardDto() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "FirstTrelloListDtos", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "SecondTrelloListDtos", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "FirstTrelloBoardDto", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "SecondTrelloBoardDto", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("1", "FirstTrelloList", true);
        TrelloList trelloList2 = new TrelloList("2", "SecondTrelloList", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        String id1 = trelloBoardDto1.getId();
        String name1 = trelloBoardDto1.getName();
        String id2 = trelloBoardDto2.getId();
        String name2 = trelloBoardDto2.getName();

        TrelloBoard trelloBoard1 = new TrelloBoard(id1, name1, trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard(id2, name2, trelloLists);
        List<TrelloBoard> testBoard = new ArrayList<>();
        testBoard.add(trelloBoard1);
        testBoard.add(trelloBoard2);

        //When
        List<TrelloBoardDto> resultBoard = trelloMapper.mapToBoardsDto(testBoard);

        //Then
        assertEquals(resultBoard.get(0).getName(), trelloBoardDtos.get(0).getName());
    }

    @Test
    void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "FirstTrelloListDtos", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "SecondTrelloListDtos", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        //When
        List<TrelloList> resultList = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(resultList.get(0).getName(), trelloListDtos.get(0).getName());
    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "TrelloList1", true);
        TrelloList trelloList2 = new TrelloList("2", "TrelloList2", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(resultList.get(0).getName(), trelloLists.get(0).getName());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "id");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "id");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
    }
}