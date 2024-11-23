package com.github.vmori29.GsMicro.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.vmori29.GsMicro.Dtos.EnergiaRenovavelRequestCreateDto;
import com.github.vmori29.GsMicro.Dtos.EnergiaRenovavelRequestUpdateDto;
import com.github.vmori29.GsMicro.Dtos.EnergiaRenovavelResponseDto;
import com.github.vmori29.GsMicro.Model.EnergiaRenovavel;

@Component
public class EnergiaRenovavelMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EnergiaRenovavelResponseDto toDto(EnergiaRenovavel EnergiaRenovavel) {
		return modelMapper.map(EnergiaRenovavel, EnergiaRenovavelResponseDto.class);
	}
	
	public EnergiaRenovavel toModel(EnergiaRenovavelRequestCreateDto dto) {
		return modelMapper.map(dto, EnergiaRenovavel.class);
	}
	
	public EnergiaRenovavel toModel(Long id,EnergiaRenovavelRequestUpdateDto dto) {
		EnergiaRenovavel result = modelMapper.map(dto,EnergiaRenovavel.class);
		result.setId(id);	
		return result;
	}
	
}
