package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.dto.UserRequest;
import com.doan.QLCSVC.dto.UserResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.Role;
import com.doan.QLCSVC.model.User;
import com.doan.QLCSVC.repo.PhongRepository;
import com.doan.QLCSVC.repo.RoleRepository;
import com.doan.QLCSVC.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService{
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    private final PhongRepository phongRepo;


    @Override
    public UserResponse saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userAdd= userRepo.save(user);
        return mapToUserResponse(userAdd);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
        Role role=roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public boolean addPhongToUser(Long userId, Long maPhong) {
        if(userRepo.existsById(userId)&&phongRepo.existsById(maPhong)){
            Phong phong=phongRepo.findById(maPhong).orElseThrow();
            User user=userRepo.findById(userId).orElseThrow();
            user.getPhongs().add(phong);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean removePhongFromUser(Long userId, Long maPhong) {
        if(userRepo.existsById(userId)&&phongRepo.existsById(maPhong)){
            Phong phong=phongRepo.findById(maPhong).orElseThrow();
            User user=userRepo.findById(userId).orElseThrow();
            user.getPhongs().remove(phong);
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public UserResponse getUser(String username) {
        User user=userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
        return mapToUserResponse(user);
    }

    @Override
    public Page<UserResponse> getUsers(UserRequest userRequest) {
        Pageable pageable= PageRequest.of(userRequest.getPage(), userRequest.getSize());
        Page<User> pageUser=userRepo.findAll(pageable);
        Page<UserResponse> pageUserResponse=pageUser.map(user->mapToUserResponse(user));
        return pageUserResponse;
    }

    @Override
    public Boolean updateUser(User user) {
        if(userRepo.existsById(user.getId())){
            User userUpdate=userRepo.findById(user.getId()).orElseThrow();
            userUpdate.setName(user.getName());
            userUpdate.setDiachi(user.getDiachi());
            userUpdate.setImage(user.getImage());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setTuoi(user.getTuoi());
            userUpdate.setChucVu(user.getChucVu());
            userUpdate.setPhone(user.getPhone());
            userRepo.save(userUpdate);
            return true;
        }
        return false;
    }

    @Override
    public Boolean changePassword(UserRequest userRequest) {

        if(userRepo.existsById(userRequest.getUserID())){
            User userUpdate=userRepo.findById(userRequest.getUserID()).orElseThrow();
            if(passwordEncoder.matches(userRequest.getPassword(),userUpdate.getPassword())){
                userUpdate.setPassword(passwordEncoder.encode(userRequest.getNewPassword()));
                userRepo.save(userUpdate);
                return true;
            }

        }
        return false;
    }

    @Override
    public Boolean deleteUser(Long id) {
       if(userRepo.existsById(id)){
           User user=userRepo.findById(id).orElseThrow();
           userRepo.delete(user);
           return true;
       }

        return false;
    }
    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .image(user.getImage())
                .diachi(user.getDiachi())
                .phongs(user.getPhongs().stream().map(this::mapToPhongResponse).collect(Collectors.toList()))
                .email(user.getEmail())
                .tuoi(user.getTuoi())
                .phone(user.getPhone())
                .chucVu(user.getChucVu())
                .username(user.getUsername())
                .roles(user.getRoles())
                .build();
    }
    public PhongResponse mapToPhongResponse(Phong phong){
        return PhongResponse.builder()
                .tenPhong(phong.getTenPhong())
                .maPhong(phong.getMaPhong())
                .build();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }
}
