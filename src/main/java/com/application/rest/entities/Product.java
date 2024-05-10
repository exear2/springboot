package com.application.rest.entities;

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
@Table(name="producto")
public class Product {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nombre")
	private String name;
	@Column(name="precio")
	private int price;
	
	@ManyToOne
	@JoinColumn(name="id_fabricante", nullable = false) //nombre clave foranea
	@JsonIgnore //serializa cuando yo se lo pida sino ignoralo
	private Maker maker;

}
