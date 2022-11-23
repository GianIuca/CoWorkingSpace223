 package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.eclipse.microprofile.jwt.Claims;

import ch.zli.m223.model.User;
import io.smallrye.jwt.build.Jwt;


@ApplicationScoped
public class AuthService {
    @Inject
    private EntityManager entityManager;


    @Transactional
    public String login( User user) {
        var entity = entityManager.find(User.class, user.getId());

        if(entity.getPassword().equals(user.getPassword())  &&  entity.getEmail().equals(user.getEmail()) ){
            if(entity.getRole().getId() == 1) {
                return generateTokenAdmin();
            } else return generateTokenMitglied();
            
        }else{
            return "you have no access!! If you are wronged please contact us at example@email.com!!";
        }

    }

    
    public String generateTokenMitglied() {
        String token =
           Jwt.issuer("https://zli.example.com/") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("Mitglied"))) 
             .claim(Claims.birthdate.name(), "2022-11-23")
             .expiresIn(Duration.ofHours(24))
           .sign();
        return token;
    }

    public String generateTokenAdmin() {
        String token =
           Jwt.issuer("https://zli.example.com/") 
             .upn("jdoe@quarkus.io") 
             .groups(new HashSet<>(Arrays.asList("Administrator"))) 
             .claim(Claims.birthdate.name(), "2022-11-23") 
             .expiresIn(Duration.ofHours(24))
           .sign();
        return token;
    }

    @Transactional
    public boolean doesThisUserExistsAlready(String email, String password) {
        boolean exists = false;
        var entities = entityManager.createQuery("FROM User", User.class);
        List<User> users = entities.getResultList();
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
                exists = true;
            }
        }
        return exists;
    }

}

