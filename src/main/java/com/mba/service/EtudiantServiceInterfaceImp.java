package com.mba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mba.dto.EtudiantRequestDTO;
import com.mba.dto.EtudiantResponseDTO;
import com.mba.entities.Etudiant;
import com.mba.mapper.EtudiantInterfaceMapper;
import com.mba.repositories.EtudiantRepository;

import jakarta.transaction.Transactional;

@Service


@Transactional
public class EtudiantServiceInterfaceImp implements EtudiantServiceInterfce {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EtudiantInterfaceMapper etudiantInterfaceMapper;
	
	@Override
	public void add(EtudiantRequestDTO e) {
		Etudiant et = new Etudiant();
		et = etudiantInterfaceMapper.from_Request_DTO_TO_Etudiant(e);
		etudiantRepository.save(et);
	}

	@Override
	public List<EtudiantResponseDTO> ListeEtudiant() {
		List<Etudiant> liste = new ArrayList<Etudiant>();
		liste = etudiantRepository.findAll();
		
		List<EtudiantResponseDTO> l = new ArrayList<EtudiantResponseDTO>();
		
		for(Etudiant e : liste) {
			EtudiantResponseDTO erdto = new EtudiantResponseDTO();
			erdto = etudiantInterfaceMapper.Etudiant_TO_ResponseDTO(e);
			l.add(erdto);
		}
		return l;
	}

	@Override
	public EtudiantResponseDTO etudiantById(Integer id) {
		Etudiant e = etudiantRepository.findById(id).get();
		EtudiantResponseDTO et = etudiantInterfaceMapper.Etudiant_TO_ResponseDTO(e);
		return et;
	}

	@Override
	public void update(Integer id, EtudiantRequestDTO e) {
		Etudiant et = etudiantRepository.findById(id).get();
		
		if(e.getApogee() != null)
			et.setApogee(e.getApogee());
		
		if(e.getNom() != null)
			et.setNom(e.getNom());
		
		if(e.getEmail() != null)
			et.setEmail(e.getEmail());
		
		etudiantRepository.save(et);
		
	}

	@Override
	public void supp(Integer id) {
		etudiantRepository.deleteById(id);
		
	}

}
