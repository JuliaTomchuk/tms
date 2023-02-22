package org.example.service.impl;
import org.example.service.MoneyService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class MoneyServiceImpl implements MoneyService {

    private int money;

    @Override
    public void setMoney(int money) {
        this.money = money;

    }

    @Override
    public int getMoney() {

        return money;
    }

    @Override
    public void multiplyMoney() {
        money = money * 2;

    }

    @Override
    public void subtractMoney(int sum) {
        money = money - sum;
    }
}
