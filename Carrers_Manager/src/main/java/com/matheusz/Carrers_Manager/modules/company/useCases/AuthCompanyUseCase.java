package com.matheusz.Carrers_Manager.modules.company.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.matheusz.Carrers_Manager.modules.company.dto.AuthCompanyDTO;
import com.matheusz.Carrers_Manager.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Username/password incorrect"));

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if(!passwordMatches){
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create().withIssuer("secJM")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(company.getId().toString())
                .sign(algorithm);
    }
}
