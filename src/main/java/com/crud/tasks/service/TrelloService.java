package com.crud.tasks.service;

import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrelloService {
    private final TrelloClient trelloClient;
    private final SimpleEmailService emailService;
}
