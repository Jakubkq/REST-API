package com.crud.tasks.domain;

import com.crud.tasks.domain.AttachmentsByType;
import com.crud.tasks.domain.Trello;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttachmentsByTypeTest {

    private AttachmentsByType attachmentsByType;

    @BeforeEach
    public void setUp() {
        attachmentsByType = new AttachmentsByType();
    }

    @Test
    public void testGetTrello() {
        // given
        Trello trello = new Trello();
        trello.setBoard(1);
        trello.setCard(2);

        attachmentsByType.setTrello(trello);

        // when
        Trello result = attachmentsByType.getTrello();

        // then
        assertEquals(trello, result);
        assertEquals(1, result.getBoard());
        assertEquals(2, result.getCard());
    }

    @Test
    public void testSetTrello() {
        // given
        Trello trello = new Trello();
        trello.setBoard(1);
        trello.setCard(2);

        // when
        attachmentsByType.setTrello(trello);

        // then
        assertEquals(trello, attachmentsByType.getTrello());
    }
}
