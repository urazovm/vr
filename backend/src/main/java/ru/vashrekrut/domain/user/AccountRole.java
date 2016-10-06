package ru.vashrekrut.domain.user;

import ru.vashrekrut.domain.DomainObject;
import ru.vashrekrut.enums.Role;

import javax.persistence.*;

/**
 * Copyright 2016 LabIt.com
 * Created by xpap on 9/23/16.
 */
@Entity
@Table(name = "account_roles")
@AttributeOverride(name = "id", column = @Column(name = "acr_id"))
public class AccountRole extends DomainObject {
    @Column(name = "acr_role")
    @Enumerated(value = EnumType.ORDINAL)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_id")
    private Account account;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
