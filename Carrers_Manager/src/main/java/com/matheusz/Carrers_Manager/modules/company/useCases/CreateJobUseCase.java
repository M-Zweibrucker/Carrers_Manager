package com.matheusz.Carrers_Manager.modules.company.useCases;

import com.matheusz.Carrers_Manager.modules.company.entities.JobEntity;
import com.matheusz.Carrers_Manager.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
        return this.jobRepository.save(jobEntity);
    }
}
