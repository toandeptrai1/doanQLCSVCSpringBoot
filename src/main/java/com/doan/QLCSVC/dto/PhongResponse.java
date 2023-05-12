package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.DanhMucPhong;
import com.doan.QLCSVC.model.TrangThai;
import com.doan.QLCSVC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhongResponse {
    private Long maPhong;
    private String tenPhong;
    private String mota;
    private String image;

    private Float chieuDai;
    private Float chieuRong;
    private String vitri;
    private DanhMucPhong danhMucPhong;
    private TrangThai trangThai;
    private List<UserResponse> users;




}
