package se.maetsskogfeldt.dao;


import org.junit.Test;
import se.maetsskogfeldt.domain.Account;

public class AccountDaoMysqlImplTest {


    @Test
    public void connectToDatabseTest() {
        AccountDaoMysqlImpl.connectToDatabase();
    }

    @Test
    public void createTest(){
        AccountDao dao = (AccountDao) new AccountDaoMysqlImpl();
        Account account = Account.builder().withId(4L).withBalance(15000d).build();
        dao.create(account);
    }

    public void readTest() {

    }

}
