package com.matheusz.Carrers_Manager.modules.candidate.useCases;

import com.matheusz.Carrers_Manager.exceptions.UserFoundException;
import com.matheusz.Carrers_Manager.modules.candidate.CandidateEntity;
import com.matheusz.Carrers_Manager.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
