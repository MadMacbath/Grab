package com.macbeth.algorithm.myhibernate;

import com.macbeth.algorithm.domain.lagou.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * author:macbeth
 * Date:2018/7/9
 * Time:10:37
 **/
public class HibernateTest {
    public static void main(String[] args){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = session.get(Company.class,1L);
        company.setDesc("test");
        session.update(company);
        if (true) throw new RuntimeException();

        transaction.commit();
        session.close();
    }
}
