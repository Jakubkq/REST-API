package com.crud.tasks.domain;

import com.crud.tasks.domain.AttachmentsByType;
import com.crud.tasks.domain.Badges;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BadgesTest {

    @Test
    public void testGetAndSetVotes() {
        // given
        int votes = 3;
        Badges badges = new Badges();

        // when
        badges.setVotes(votes);

        // then
        assertEquals(votes, badges.getVotes());
    }

    @Test
    public void testGetAndSetAttachments() {
        // given
        AttachmentsByType attachments = new AttachmentsByType();
        Badges badges = new Badges();

        // when
        badges.setAttachments(attachments);

        // then
        assertNotNull(badges.getAttachments());
        assertEquals(attachments, badges.getAttachments());
    }

    @Test
    public void testJsonIgnoreProperties() {
        // given
        Badges badges = new Badges();

        // then
        assertNotNull(badges.getClass().getAnnotation(JsonIgnoreProperties.class));
        assertEquals(true, badges.getClass().getAnnotation(JsonIgnoreProperties.class).ignoreUnknown());
    }
}