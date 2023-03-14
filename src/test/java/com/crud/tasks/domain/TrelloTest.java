package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrelloTest {


    @Test
    public void testSetAndGetBoard() {
        // given
        Trello trello = new Trello();
        int expectedBoard = 123;

        // when
        trello.setBoard(expectedBoard);
        int retrievedBoard = trello.getBoard();

        // then
        assertEquals(expectedBoard, retrievedBoard);
    }

    @Test
    public void testSetAndGetCard() {
        // given
        Trello trello = new Trello();
        int expectedCard = 456;

        // when
        trello.setCard(expectedCard);
        int retrievedCard = trello.getCard();

        // then
        assertEquals(expectedCard, retrievedCard);
    }

    @Test
    public void testJsonIgnoreUnknown() {
        // given
        Trello trello = new Trello();

        // when
        boolean ignoreUnknown = trello.getClass().getAnnotation(JsonIgnoreProperties.class)
                .ignoreUnknown();

        // then
        assertTrue(ignoreUnknown);
    }

    @Test
    public void testJsonProperty() {
        // given
        Trello trello = new Trello();
        int expectedBoard = 789;
        int expectedCard = 321;

        // when
        trello.setBoard(expectedBoard);
        trello.setCard(expectedCard);
        int retrievedBoard = trello.getBoard();
        int retrievedCard = trello.getCard();

        // then
        assertEquals(expectedBoard, retrievedBoard);
        assertEquals(expectedCard, retrievedCard);
    }
}