package com.github.vmori29.GsMicro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.vmori29.GsMicro.Dtos.EnergiaRenovavelResponseDto;
import com.github.vmori29.GsMicro.Mapper.EnergiaRenovavelMapper;
import com.github.vmori29.GsMicro.Views.EnergiaRenovavelInformationView;
import com.github.vmori29.GsMicro.Views.EnergiaRenovavelValueView;
import com.github.vmori29.GsMicro.Views.EnergiaRenovavelViewType;
import com.github.vmori29.GsMicro.repository.EnergiaRenovavelRepository;
import com.github.vmori29.GsMicro.service.EnergiaRenovavelService;

@RestController
@RequestMapping("/energiaRenovavel")
public class EnergiaRenovavelController {

	@Autowired
	private EnergiaRenovavelService service;
	@Autowired
	private EnergiaRenovavelRepository repository;
	@Autowired
	private EnergiaRenovavelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<EnergiaRenovavelResponseDto>> list(){
		List<EnergiaRenovavelResponseDto> dto = service.list()
	            .stream()
	            .map(e -> mapper.toDto(e))
	            .toList();
		
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EnergiaRenovavelResponseDto> findById(@PathVariable Long id) {
		return ResponseEntity.ok()
    			.body(
    					service
    					.findById(id)
    					.map(e -> mapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);  

	}
	
	@GetMapping("/find")
	public ResponseEntity<?> findBySmartGrid(@RequestParam String smartGrid, EnergiaRenovavelViewType type) {
		 switch (type) {
         case VALUES:
             return ResponseEntity.ok().body(repository.findAllBySmartGridContains(smartGrid, EnergiaRenovavelValueView.class));                
         case INFORMATION:
             return ResponseEntity.ok().body(repository.findAllBySmartGridContains(smartGrid, EnergiaRenovavelInformationView.class));            
     }
     return ResponseEntity.noContent().build();

	}
}
