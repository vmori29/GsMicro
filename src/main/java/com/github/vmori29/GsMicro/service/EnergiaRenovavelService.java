package com.github.vmori29.GsMicro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vmori29.GsMicro.Model.EnergiaRenovavel;
import com.github.vmori29.GsMicro.repository.EnergiaRenovavelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnergiaRenovavelService {

	@Autowired
	private EnergiaRenovavelRepository repository;
	
	public List<EnergiaRenovavel> list(){
		return repository.findAll();
	}
	
	public EnergiaRenovavel save(EnergiaRenovavel Energia) {
		return repository.save(Energia);
	}

	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Optional<EnergiaRenovavel> findById(Long id) {
		return repository.findById(id);
	}

}
