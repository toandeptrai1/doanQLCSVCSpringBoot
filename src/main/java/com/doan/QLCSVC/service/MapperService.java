package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.dto.TaiSanResponse;
import com.doan.QLCSVC.dto.UserResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.model.User;

public class MapperService {
    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .chucVu(user.getChucVu())
                .image(user.getImage())
                .phone(user.getPhone())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }
    public PhongResponse mapToPhongResponse(Phong phong){
        return PhongResponse.builder()
                .tenPhong(phong.getTenPhong())
                .maPhong(phong.getMaPhong())
                .chieuDai(phong.getChieuDai())
                .chieuRong(phong.getChieuRong())
                .trangThai(phong.getTrangThai())
                .vitri(phong.getVitri())
                .danhMucPhong(phong.getDanhMucPhong())
                .build();
    }
    public TaiSanResponse mapToTaiSanResponse(TaiSan taiSan){
        return TaiSanResponse.builder()
                .tenTS(taiSan.getTenTS())
                .maTS(taiSan.getMaTS())
                .trangThai(taiSan.getTrangThai())
                .danhMucTaiSan(taiSan.getDanhMucTaiSan())
                .hangSanXuat(taiSan.getHangSanXuat())
                .namSanXuat(taiSan.getNamSanXuat())
                .boMachChu(taiSan.getBoMachChu())
                .cacXuLyDoHoa(taiSan.getCacXuLyDoHoa())
                .congXuat(taiSan.getCongXuat())
                .image(taiSan.getImage())
                .imageQR(taiSan.getImageQR())
                .viSuLy(taiSan.getViSuLy())
                .khac(taiSan.getKhac())
                .boNho(taiSan.getBoNho())
                .phong(mapToPhongResponse(taiSan.getPhong()))
                .build();
    }
}
