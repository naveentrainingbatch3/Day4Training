package com.edureka.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="inventory")

@AllArgsConstructor
@NoArgsConstructor

@Builder
@Data
@EqualsAndHashCode(exclude = "id")
public class Product {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "description")
	String description;

}

/*
 * inventory
 * |id|name|descpriont|
 */
