package com.example.demo1.repository;

import com.example.demo1.model.Mailbox;

public interface IMailboxRepository {
    Mailbox getCurrentMailbox();

    void changeCurrentMailbox(Mailbox newMailbox);
}
