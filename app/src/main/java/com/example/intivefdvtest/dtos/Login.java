package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Login implements Serializable {

    private final String uuid;
    private final String username;
    private final String password;
    private final String salt;
    private final String md5;
    private final String sha1;
    private final String sha256;

    /**
     * @param uuid the uuid
     * @param username the username
     * @param password the password
     * @param salt the salt
     * @param md5 the md5
     * @param sha1 the sha1
     * @param sha256 the sha 256
     */
    public Login(final String uuid, final String username, final String password, final String salt, final String md5,
        final String sha1,
        final String sha256) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getMd5() {
        return md5;
    }

    public String getSha1() {
        return sha1;
    }

    public String getSha256() {
        return sha256;
    }
}
