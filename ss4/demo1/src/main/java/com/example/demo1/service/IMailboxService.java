package com.example.demo1.service;

import com.example.demo1.model.Mailbox;

public interface IMailboxService {
    Mailbox getCurrentMailbox();

    void changeCurrentMailbox(Mailbox newMailbox);
}
