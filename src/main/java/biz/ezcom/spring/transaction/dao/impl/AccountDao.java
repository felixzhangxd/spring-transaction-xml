package biz.ezcom.spring.transaction.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import biz.ezcom.spring.transaction.dao.api.IAccountDao;
import biz.ezcom.spring.transaction.po.Account;

@Repository
public class AccountDao implements IAccountDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(final Account account) {
        final String sql = "INSERT INTO account (name, password, balance) VALUES(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, account.getName());
                ps.setString(2, account.getPassword());
                ps.setDouble(3, account.getBalance());
                return ps;
            }
        }, keyHolder);
        int id = keyHolder.getKey().intValue();
        account.setId(id);
    }

    @Override
    public void remove(Integer id) {
        String sql = "DELETE FROM account WHERE id=" + id;
        jdbcTemplate.update(sql);
    }

    @Override
    public void modify(Account account) {
        String sql = "UPDATE account SET name=?,password=?,balance=? WHERE id=?";
        Object[] args = new Object[] { account.getName(), account.getPassword(), account.getBalance(), account.getId() };
        int[] argTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.DOUBLE, Types.INTEGER };
        jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public Account find(Integer id) {
        String sql = "SELECT id,name,password,balance FROM account WHERE id=" + id;
        List<Account> accounts = jdbcTemplate.query(sql, new Account());
        if (accounts.isEmpty()) {
            return null;
        } else {
            return accounts.get(0);
        }
    }
}
