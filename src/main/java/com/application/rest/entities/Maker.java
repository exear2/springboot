package com.application.rest.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fabricante")
public class Maker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	private String name;
	
@OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, mappedBy = "maker", orphanRemoval = true)
@JsonIgnore //serializa cuando yo se lo pida sino ignoralo
private List<Product> productList=new ArrayList<>();
	
	
	
	
	

}
