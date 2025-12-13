package com.cart.problem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cpId;

    @Column(name = "cart_id", insertable = false, updatable = false)
    private int cartId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private int productId;

    @ManyToOne()
    @JoinColumn(name = "cart_id", referencedColumnName = "cartId")
    @JsonIgnore
    private Cart cart;

    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    private Integer quantity = 1;

    @Override
    public String toString() {
        return "CartProduct{" +
                "cpId=" + cpId +
                ", cartId=" + cartId +
                ", productId=" + productId +
                ", cart=" + cart +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
