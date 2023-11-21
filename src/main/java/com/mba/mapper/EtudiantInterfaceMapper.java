package com.mba.mapper;

import com.mba.dto.EtudiantRequestDTO;
import com.mba.dto.EtudiantResponseDTO;
import com.mba.entities.Etudiant;

public interface EtudiantInterfaceMapper {
	
	public Etudiant from_Request_DTO_TO_Etudiant(EtudiantRequestDTO edto);
	
	public EtudiantResponseDTO Etudiant_TO_ResponseDTO(Etudiant e);
	
}
