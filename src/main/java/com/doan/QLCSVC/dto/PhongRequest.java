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
public class PhongRequest {
    private Long maPhong;
    private String tenPhong;
    private DanhMucPhong danhMucPhong;
    private String mota;
    private Integer page;
    private String image;
    private Integer size;
    private List<User> users;
    private Float chieuDai;
    private Float chieuRong;
    private TrangThai trangThai;
    private String vitri;

}
