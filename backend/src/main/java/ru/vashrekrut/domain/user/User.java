package ru.vashrekrut.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vashrekrut.domain.DomainObject;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by root on 9/1/16.
 */
@Entity
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "usr_id"))
public class User extends DomainObject {
    @Column(name = "usr_login")
    private String login;

    @Column(name = "usr_password")
    private String password;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;

    @Temporal(TemporalType.DATE)
    @Column(name = "usr_creation_date")
    private Date creationDate;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
