package se.maetsskogfeldt.dao;

import se.maetsskogfeldt.domain.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AccountDaoMysqlImpl implements AccountDao {

    private static Connection connection = null;

    public static Connection connectToDatabase() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AccountBase" +
                            "?useUnicode=true" +
                            "&useJDBCCompliantTimezoneShift=true" +
                            "&useLegacyDatetimeCode=false" +
                            "&serverTimezone=UTC" +
                            "&autoReconnect=true" +
                            "&useSSL=false",
                    "root", "tkok01");
            System.out.println("Connection to database established");
            return connection;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public void create(Account account) {
        PreparedStatement preparedStatement = null;
        connectToDatabase();
        String sql = "INSERT INTO accounts VALUES(?, ?)";


        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, account.getId());
            preparedStatement.setDouble(2, account.getBalance());

            preparedStatement.executeUpdate();
            System.out.println("Great Success!");

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    @Override
    public Optional<Account> read(Long id) {


        return Optional.empty();
    }


    @Override
    public Collection<Account> readAccountsWithBalanceOver(Double Limit) {
        return null;
    }

    @Override
    public Map<Long, Account> getAccounts() {
        return null;
    }

}

/*
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

