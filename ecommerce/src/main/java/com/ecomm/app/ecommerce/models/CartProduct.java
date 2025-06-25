package com.ecomm.app.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartProductId;
	@Column(name = "cart_id", updatable = false, insertable = false)
	private int cartId;
	@Column(name = "product_id", updatable = false, insertable = false)
	private int productId;
	@ManyToOne
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	@JsonIgnore
	private Cart cart;
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "productId")
	private Product product;
	private Integer quantity = 1;
}
