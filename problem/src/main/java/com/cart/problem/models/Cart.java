package com.cart.problem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private double totalAmount;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    @JsonIgnore
    private UserInfo user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartProduct> cartProducts;

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalAmount=" + totalAmount +
                ", user=" + user +
                ", cartProducts=" + cartProducts +
                '}';
    }
}
