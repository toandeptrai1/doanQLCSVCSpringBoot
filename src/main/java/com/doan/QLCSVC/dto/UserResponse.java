package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.ChucVu;
import com.doan.QLCSVC.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserResponse {
    private Long  id;
    private String name;
    private String username;
    private String password;
    private String diachi;
    private String email;
    private Integer tuoi;
    private String phone;
    private Collection<Role> roles;

    private ChucVu chucVu;

    private String image;
    private List<PhongResponse> phongs;
    

}
