package com.github.vmori29.GsMicro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vmori29.GsMicro.Model.EnergiaRenovavel;

public interface EnergiaRenovavelRepository extends JpaRepository<EnergiaRenovavel, Long>{
	<T> List<T> findAllBySmartGridContains(String smartGrid, Class<T> type);
}
