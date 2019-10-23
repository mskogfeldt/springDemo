package se.maetsskogfeldt.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.domain.Account;

import java.util.Optional;

public class SpringMain {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new GenericXmlApplicationContext("applicationContext.xml");
        AccountDao dao = applicationContext.getBean(AccountDao.class);
        Optional<Account> optional = dao.read(1L);
        System.out.println("if presant: " + optional.isPresent());
        dao.create(Account.builder().withId(1L).withBalance(15000d).build());
        Optional<Account> optional2 = dao.read(1L);
        System.out.println("if presant: " + optional2.isPresent());


    }
}
