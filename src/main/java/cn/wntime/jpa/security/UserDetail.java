package cn.wntime.jpa.security;

import cn.wntime.jpa.domain.UserInfo;
import cn.wntime.jpa.domain.UserRoleRef;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserDetail implements UserDetails {

    private  String mobilePhone;
    private String email;
    private String password;
    private String username;
    private Set<GrantedAuthority> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserDetail(UserInfo userInfo) {
        this.username = userInfo.getLoginName();
        this.password = userInfo.getPassword();
        this.email = userInfo.getEmail();
        this.mobilePhone = userInfo.getMobilePhone();
        this.authorities = new HashSet<>();
        for (UserRoleRef ref : userInfo.getUserRoleRefs()) {
            this.authorities.add(new SimpleGrantedAuthority(ref.getRole().getRoleCode()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
