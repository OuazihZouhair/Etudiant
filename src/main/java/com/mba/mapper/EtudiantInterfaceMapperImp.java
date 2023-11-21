package com.mba.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mba.dto.EtudiantRequestDTO;
import com.mba.dto.EtudiantResponseDTO;
import com.mba.entities.Etudiant;


@Component
public class EtudiantInterfaceMapperImp implements EtudiantInterfaceMapper {

	@Override
	public Etudiant from_Request_DTO_TO_Etudiant(EtudiantRequestDTO edto) {
		Etudiant e = new Etudiant();
		e.setApogee(edto.getApogee());
		e.setNom(edto.getNom());
		e.setEmail(edto.getEmail());
		return e;
	}

	@Override
	public EtudiantResponseDTO Etudiant_TO_ResponseDTO(Etudiant e) {
		EtudiantResponseDTO erdto = new EtudiantResponseDTO();
		BeanUtils.copyProperties(e, erdto);
		return erdto;
	}

}
