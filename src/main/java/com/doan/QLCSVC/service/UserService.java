package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.UserRequest;
import com.doan.QLCSVC.dto.UserResponse;
import com.doan.QLCSVC.model.Role;
import com.doan.QLCSVC.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserResponse saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    boolean addPhongToUser(Long userId,Long maPhong);
    UserResponse getUser(String username);
    Page<UserResponse> getUsers(UserRequest userRequest);
    Boolean updateUser(User user);

    Boolean changePassword(UserRequest user);
    Boolean deleteUser(Long id);
    List<Role> getRoles();
}
