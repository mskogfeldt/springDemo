package se.maetsskogfeldt.service;

import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.domain.Account;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Double getBalance(Long id) {
        Optional<Account> optionalAccount = accountDao.read(id);
        if (optionalAccount.isPresent()){
            return optionalAccount.get().getBalance();
        }
        return 0.00;
    }

}
