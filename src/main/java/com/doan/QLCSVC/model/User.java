package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String username;
    private String password;
    private String diachi;
    private String email;
    private Integer tuoi;

    private String image;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maChucVu",referencedColumnName = "maChucVu")
    private ChucVu chucVu;

    private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Role> roles=new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Phong> phongs;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        for (Role role:roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));

        }
        return authorities;
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
