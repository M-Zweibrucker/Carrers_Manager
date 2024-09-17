package com.matheusz.Carrers_Manager.modules.candidate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileCandidateDTO {

    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;
}
