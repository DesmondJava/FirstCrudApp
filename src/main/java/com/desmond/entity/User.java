package com.desmond.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vadym on 10.11.2014.
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 8)
    private long id;

    @Column(name = "name", length = 25)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "isadmin", nullable = false)
    private boolean isAdmin;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public User(String name, int age, boolean isAdmin) {
        this.name = name;
        this.age = age;
        this.isAdmin = isAdmin;
        createdDate = new Date();
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isAdmin=" + isAdmin +
                ", createdDate=" + createdDate +
                '}';
    }
}