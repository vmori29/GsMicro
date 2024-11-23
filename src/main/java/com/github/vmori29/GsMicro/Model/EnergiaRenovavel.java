package com.github.vmori29.GsMicro.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EnergiaRenovavel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length =50)
	private String smartGrid;
	
	@Column(nullable = false, length = 50)
	private String EnergiaTipo;
	
	@Column(precision = 20, scale=2)
	private BigDecimal KW;
	
	@Column(nullable = false, length = 20)
	private String fornecedor;
	
	@Column(nullable = false, length = 20)
	private String tipoBateria;
}
