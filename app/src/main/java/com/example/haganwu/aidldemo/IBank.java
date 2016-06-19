package com.example.haganwu.aidldemo;

/**
 * Created by haganwu on 16/6/19.
 */

public interface IBank {
    /**
     * 开户
     * @param name 户主名字
     * @param password 密码
     * @return 开户信息
     */
    String openAccount(String name , String password);

    /**
     * 存钱
     * @param money 金额
     * @param account 账号
     * @return 存钱信息
     */
    String saveMoney(int money , String account );

    /**
     * 娶亲
     * @param money 金额
     * @param account 账号
     * @param password 密码
     * @return 取钱信息
     */
    String takeMoney(int money , String account , String password);

    /**
     * 销户
     * @param account 账户
     * @param password 密码
     * @return 销户信息
     */
    String closeAccount(String account , String password);
}
