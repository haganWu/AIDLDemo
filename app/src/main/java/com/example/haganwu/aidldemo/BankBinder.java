package com.example.haganwu.aidldemo;


import java.util.UUID;

/**
 * Created by haganwu on 16/6/19.
 */

public class BankBinder extends IBankAIDL.Stub{
    @Override
    public String openAccount(String name, String password) {
        return name + "开户成功!账号为"+ UUID.randomUUID().toString();
    }

    @Override
    public String saveMoney(int money, String account) {
        return "账户"+account +"存入"+money+"人民币";
    }

    @Override
    public String takeMoney(int money, String account, String password) {
        return "账户"+account+"支出"+money+"人民币";
    }

    @Override
    public String closeAccount(String account, String password) {
        return account+"销户成功!";
    }

}
