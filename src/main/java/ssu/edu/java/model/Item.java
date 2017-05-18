package ssu.edu.java.model;

import javax.persistence.*;

/**
 * Created by Александр on 18.05.2017.
 */
@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ITEM_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "ITEM_TITLE")
    private String title;

    @Column(name = "ITEM_PRICE")
    private int price;

    @Column(name = "IS_BOUGHT")
    private boolean isBought;

    @ManyToOne
    @JoinColumn(name = "BUYER")
    private User buyer;

    public Item(String title, int price, boolean isBought) {
        this.title = title;
        this.price = price;
        this.isBought = isBought;
    }

    public Item() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", isBought=" + isBought +
                ", buyer=" + buyer +
                '}';
    }
}
