package cn.itcast.service;

import cn.itcast.dao.AccountDao;
import cn.itcast.domin.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface AccountService {



    //查询所有账户
    public List<Account> findAll();

    //保存账户信息
    public void savaAccount(Account account);

}
