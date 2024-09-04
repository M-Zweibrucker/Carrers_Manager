package com.matheusz.Carrers_Manager.modules.company.repositories;

import com.matheusz.Carrers_Manager.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

}
