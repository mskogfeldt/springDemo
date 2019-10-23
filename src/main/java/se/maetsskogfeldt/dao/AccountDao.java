package se.maetsskogfeldt.dao;

import se.maetsskogfeldt.domain.Account;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface AccountDao {

    void create(Account acconut);

    Optional<Account> read(Long id);

    Collection<Account> readAccountsWithBalanceOver(Double Limit);

    public Map<Long, Account> getAccounts();
}
