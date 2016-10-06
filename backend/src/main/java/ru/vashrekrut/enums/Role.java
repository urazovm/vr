package ru.vashrekrut.enums;

/**
 * Created by root on 9/14/16.
 */
public enum Role {
    ADMIN(0),
    USER(1);

    int value;

    Role(int value) {
        this.value = value;
    }
}
