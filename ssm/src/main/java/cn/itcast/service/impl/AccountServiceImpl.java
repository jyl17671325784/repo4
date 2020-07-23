package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domin.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层，查询所有账户。。");
        List<Account> ls = accountDao.findAll();
        return ls;
    }

    @Override
    public void savaAccount(Account account) {
//        accountDao.savaAccount();
        System.out.println("业务层：保存账户");
    }
}
