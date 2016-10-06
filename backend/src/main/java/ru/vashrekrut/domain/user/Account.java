package ru.vashrekrut.domain.user;

import ru.vashrekrut.domain.DomainObject;
import ru.vashrekrut.domain.examination.AccountExamination;
import ru.vashrekrut.enums.AccountState;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 9/3/16.
 */
@Entity
@Table(name = "accounts")
@AttributeOverride(name = "id", column = @Column(name = "acc_id"))
@NamedQuery(name = "Account.findByLogin", query = "SELECT a FROM Account a WHERE a.user.login = :login")
public class Account extends DomainObject {

    public static final String FIND_BY_LOGIN = "Account.findByLogin";

    @Column(name = "acc_name")
    private String name;

    @Column(name = "acc_suname")
    private String surname;

    @Column(name = "acc_phone")
    private String phone;

    @Column(name = "acc_legal")
    private boolean legal;

    @Column(name = "acc_state")
    @Enumerated(value = EnumType.ORDINAL)
    private AccountState state;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<AccountRole> roles = new HashSet<>(0);

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<AccountExamination> accountExaminations = new HashSet<>(0);

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "acc_last_login_time")
    private Date lastLoginTime;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private User user;

    // secret key never should be stored
    @Transient
    private String secretKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Set<AccountRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AccountRole> roles) {
        this.roles = roles;
    }

    public Set<AccountExamination> getAccountExaminations() {
        return accountExaminations;
    }

    public void setAccountExaminations(Set<AccountExamination> accountExaminations) {
        this.accountExaminations = accountExaminations;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
