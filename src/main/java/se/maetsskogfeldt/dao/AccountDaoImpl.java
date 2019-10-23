package se.maetsskogfeldt.dao;

import se.maetsskogfeldt.domain.Account;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AccountDaoImpl implements AccountDao {
    private Map<Long, Account> accounts = new HashMap();

    public void create(Account account) {

        if (accounts.containsKey(account.getId())) {
            throw new RuntimeException("Alredy exists");
        }

        accounts.put(account.getId(), account);
    }


    public Optional<Account> read(Long id) {
        return Optional.ofNullable(accounts.get(id));
    }

    @Override
    public Map<Long, Account> getAccounts() {
        return accounts;
    }





    public Collection<Account> readAccountsWithBalanceOver(Double limit) {
        return accounts.values().stream()
                .filter(account -> account.getBalance() > limit)
                .collect(Collectors.toSet());
    }

    /*
    public Collection<Account> readAccountWithBalanceOver(Double limit) {
        Collection<Account> tempList = accounts.values();
        Stream<Account> stream1 = tempList.stream();
        Stream<Account> stream2 = stream1.filter(account -> account.getBalance() > limit);
        Collection<Account> tempList2 = stream2.collect(Collectors.toSet());
        return tempList2;
        }
    }
    */

}

