package se.maetsskogfeldt.dao;

import se.maetsskogfeldt.dao.AccountDao;
import se.maetsskogfeldt.domain.Account;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountDaoHibernateImpl implements AccountDao {
    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("springDemo");

    public static void main(String[] args) {
        ENTITY_MANAGER_FACTORY.close();
    }

    public void addAccountToDatabase(Account account) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            em.persist(account);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }


    public static Account getAccount(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String query = "SELECT c FROM Account c WHERE c.id = :accountId";

        TypedQuery<Account> tq = em.createQuery(query, Account.class);
        tq.setParameter("accountId", id);
        Account account = null;
        try {
            account = tq.getSingleResult();
            return account;

        }
        catch (NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
        return null;
    }

    public static void getAccounts(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String strQuery = "SELECT c FROM Account c WHERE c.id IS NOT NULL";
        TypedQuery<Account> tq = em.createQuery(strQuery, Account.class);
        List<Account> accounts;
       // try {
            accounts = tq.getResultList();
            accounts.forEach(account -> System.out.println(account.getId() + " "
                    + account.getBalance()));

        //catch
    }
/*
    public static void changeBalance(Long id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        Account account = null;
        try {
            et = em.getTransaction();
            et.begin();
            account = new Account.Builder().withId(id).withBalance(balance).build();
            em.persist(account);
            et.commit();
        } catch (Exception ex) {
            if (et != null) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }


 */

    @Override
    public void create(Account acconut) {
        addAccountToDatabase(acconut);
    }

    @Override
    public Optional<Account> read(Long id) {
        return Optional.ofNullable(getAccount(id));

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
