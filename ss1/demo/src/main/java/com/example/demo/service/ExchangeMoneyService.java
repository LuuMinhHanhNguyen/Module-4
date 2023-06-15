package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ExchangeMoneyService implements IExchangeMoneyService {
    @Override
    public double exchangeMoney(double amount, double rate) {
        if (amount < 0 || rate < 0) {
            return -1;
        } else {
            return amount * rate;
        }
    }
}
