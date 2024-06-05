package org.user.api.service;

public interface TokenManagerService {

    String generateJwt(String subject);

    boolean validateJwt(String jwt);

    String getSubjectFromJwt(String jwt);
}
