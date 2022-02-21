package com.example.santander.model;

import java.util.ArrayList;
import java.util.List;

public class AccountsList {
    private static List<AccountModel> contas = new ArrayList<>();

    public void adiciona(AccountModel account){
        AccountsList.contas.add(account);
    }

    public List<AccountModel> findAccount(){
        return AccountsList.contas;
    }
}
