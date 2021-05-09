package io.raute.jpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditor implements AuditorAware<String> {

    @Value("${project.init-data}")
    private Boolean initData;

    @Override
    public Optional<String> getCurrentAuditor() {
        if (initData){
            return Optional.of("admin");
        }
        UserDetails user;
        try {
            user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return Optional.ofNullable(user.getUsername());
        }catch (Exception e){
            return Optional.empty();
        }
    }
}