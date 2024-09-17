package com.matheusz.Carrers_Manager.modules.candidate.useCases;

import com.matheusz.Carrers_Manager.modules.candidate.CandidateRepository;
import com.matheusz.Carrers_Manager.modules.candidate.dto.ProfileCandidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateDTO execute(UUID idCandidate){
        var candidate =  this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return ProfileCandidateDTO.builder()
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();
    }
}
