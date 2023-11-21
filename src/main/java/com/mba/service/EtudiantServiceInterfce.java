package com.mba.service;

import java.util.List;

import com.mba.dto.EtudiantRequestDTO;
import com.mba.dto.EtudiantResponseDTO;

public interface EtudiantServiceInterfce {

	//POST
	public void add(EtudiantRequestDTO e);
	
	//GET
	public List<EtudiantResponseDTO> ListeEtudiant();
	
	//GET by id
	public EtudiantResponseDTO etudiantById(Integer id);
	
	//PUT
	public void update(Integer id, EtudiantRequestDTO e);
	
	//DELETE
	public void supp(Integer id);
	
}
