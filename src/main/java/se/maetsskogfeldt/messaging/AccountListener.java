package se.maetsskogfeldt.messaging;

import se.maetsskogfeldt.domain.Account;

public interface AccountListener {
    void onAccount(Account account);

}
