package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ApplicationUser {

    @Id
    @SequenceGenerator(name = "user_id_gen", initialValue = 10, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")

    private Long id;

    private String login;

    private String password;

    @OneToOne
    private AccountType accountType;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private Set<Gallery> galleries = new HashSet<>();


    public ApplicationUser() {
    }

    public ApplicationUser(String login, String password,
                           AccountType accountType, Set<Gallery> galleries) {
        this.login = login;
        this.password = password;
        this.accountType = accountType;
        this.galleries = galleries;
    }

    public ApplicationUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Set<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(Set<Gallery> galleries) {
        this.galleries = galleries;
    }
}
