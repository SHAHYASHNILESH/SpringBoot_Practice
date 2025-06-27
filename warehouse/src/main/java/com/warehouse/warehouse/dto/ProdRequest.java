package com.warehouse.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("unused")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProdRequest {

	private String name;
	private String description;
	private String vendor;
	private int price;
	private int stock;
	private String currency;
	private String image_url;
	private String sku;
	private String targetUsername;
}
