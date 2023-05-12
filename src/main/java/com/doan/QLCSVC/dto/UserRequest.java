package com.doan.QLCSVC.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
    private Integer page;
    private Integer size;

    private Long userID;
    private Long maPhong;
    private String password;
    private String newPassword;
    private Long maChucVu;

}
