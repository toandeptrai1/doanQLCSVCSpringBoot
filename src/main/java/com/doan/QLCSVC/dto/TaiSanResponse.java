package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.DanhMucTaiSan;
import com.doan.QLCSVC.model.TrangThai;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaiSanResponse {
    private Long maTS;
    private String tenTS;

    private String namSanXuat;
    private String hangSanXuat;
    private String image;
    private String imageQR;

    //Thong so
    private String boNho;
    private String viSuLy;
    private String boMachChu;
    private String cacXuLyDoHoa;
    private String khac;
    private String congXuat;
    private DanhMucTaiSan danhMucTaiSan;
    private TrangThai trangThai;

    private PhongResponse phong;

}
