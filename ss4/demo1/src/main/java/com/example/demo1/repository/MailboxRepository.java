package com.example.demo1.repository;

import com.example.demo1.model.Mailbox;
import org.springframework.stereotype.Repository;

@Repository
public class MailboxRepository  implements IMailboxRepository{
    private static Mailbox currentMailbox;
    static {
        currentMailbox = new Mailbox("english", 5, false, "Thor, King Arthur");
    }
    @Override
    public Mailbox getCurrentMailbox() {
        return currentMailbox;
    }

    @Override
    public void changeCurrentMailbox(Mailbox newMailbox) {
        currentMailbox = newMailbox;
    }
}
