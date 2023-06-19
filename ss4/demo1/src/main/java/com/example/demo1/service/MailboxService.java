package com.example.demo1.service;

import com.example.demo1.model.Mailbox;
import com.example.demo1.repository.IMailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailboxService implements IMailboxService{
    @Autowired
    private IMailboxRepository iMailboxRepository;
    @Override
    public Mailbox getCurrentMailbox() {
        return iMailboxRepository.getCurrentMailbox();
    }

    @Override
    public void changeCurrentMailbox(Mailbox newMailbox) {
        iMailboxRepository.changeCurrentMailbox(newMailbox);
    }

}
