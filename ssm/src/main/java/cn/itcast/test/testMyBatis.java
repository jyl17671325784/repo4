package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domin.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class testMyBatis {
    @Test
    public void run1() throws Exception {

        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao accountdao = sqlSession.getMapper(AccountDao.class);
        List<Account> ls = accountdao.findAll();
        ls.forEach(at -> System.out.println(at));
        sqlSession.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setMoney(200d);
        account.setName("fj");
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        AccountDao accountdao = sqlSession.getMapper(AccountDao.class);
        accountdao.savaAccount(account);
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }


}
