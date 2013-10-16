package biz.ezcom.spring.transaction.po;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Account implements RowMapper<Account> {
    private Integer id;
    private String  name;
    private String  password;
    private Double  balance;

    public Account() {}

    public Account(Integer id, String name, String password, Double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        return this.getId() + 3 * this.getName().hashCode() + 5 * this.getPassword().hashCode() + 7 * this.getBalance().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (obj.getClass() != this.getClass())) {
            return false;
        }
        Account user = (Account) obj;
        if (this.getId() != user.getId()) {
            return false;
        }
        if (!this.getName().equals(user.getName())) {
            return false;
        }
        if (!this.getPassword().equals(user.getPassword())) {
            return false;
        }
        if (!this.getBalance().equals(user.getBalance())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getId() + " : " + this.getName() + " : " + this.getPassword() + " : " + this.getBalance();
    }

    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setPassword(rs.getString("password"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
}
