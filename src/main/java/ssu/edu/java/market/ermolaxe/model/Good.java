package ssu.edu.java.market.ermolaxe.model;

import javax.persistence.*;

/**
 * Created by Александр on 11.05.2017.
 */
@Entity
@Table(name = "goods")
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "good_id", unique = true, nullable = false)
    private int id;

    @Column(name = "good_name")
    private String name;

    @Column(name = "good_price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Good(int id, String name, int price, User user) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.user = user;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
