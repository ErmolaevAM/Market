package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Александр on 10.05.2017.
 */

@Entity
@Table(name = "users")
@NamedQuery(name = "Users.getAll", query = "select a from User a")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", unique = true, nullable = false)
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_role")
    private Role role;

    @Column(name = "user_address")
    private String address;

    @Column(name = "debet_card_number")
    private long debetCardNumber;

    @Column(name = "password")
    private int password;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Good> goodSet = new HashSet<>();

    public User(int id, String name, Role role, String address, Long debetCardNumber, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.address = address;
        this.debetCardNumber = debetCardNumber;
        this.password = password.hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDebetCardNumber() {
        return debetCardNumber;
    }

    public void setDebetCardNumber(Long debetCardNumber) {
        this.debetCardNumber = debetCardNumber;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.hashCode();
    }

}
