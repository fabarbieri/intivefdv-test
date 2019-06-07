package com.example.intivefdvtest.dtos;

import java.io.Serializable;

/**
 * Created by fbarbieri on 2019-06-05.
 */
public class Contact implements Serializable {

    private final String gender;
    private final Name name;
    private final Location location;
    private final String email;
    private final Login login;
    private final Dob dob;
    private final Registered registered;
    private final String phone;
    private final String cell;
    private final Id id;
    private final Picture picture;
    private final String nat;

    /**
     * @param gender the contact gender
     * @param name the contact name
     * @param location the contact location
     * @param email the contact email
     * @param login the contact login info
     * @param dob the contact data of birth
     * @param registered the registeded info
     * @param phone the contact phone
     * @param cell the contact cell
     * @param id the contact id
     * @param picture the contact picture
     * @param nat the nat
     */
    public Contact(final String gender, final Name name, final Location location, final String email, final Login login,
        final Dob dob, final Registered registered, final String phone, final String cell, final Id id,
        final Picture picture, final String nat) {
        this.gender = gender;
        this.name = name;
        this.location = location;
        this.email = email;
        this.login = login;
        this.dob = dob;
        this.registered = registered;
        this.phone = phone;
        this.cell = cell;
        this.id = id;
        this.picture = picture;
        this.nat = nat;
    }

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Login getLogin() {
        return login;
    }

    public Dob getDob() {
        return dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public String getPhone() {
        return phone;
    }

    public String getCell() {
        return cell;
    }

    public Id getId() {
        return id;
    }

    public Picture getPicture() {
        return picture;
    }

    public String getNat() {
        return nat;
    }
}
