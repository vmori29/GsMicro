package com.github.vmori29.GsMicro.Dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnergiaRenovavelRequestCreateDto {
	
	private String EnergiaTipo;
	
	private BigDecimal KW;
	
	private String fornecedor;
	
	private BigDecimal tipoBateria;
}
