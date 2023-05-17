package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongTinTLResponse {
    private Long maThanhLy;
    private String tenThanhLy;
    private String moTa;
    private String coQuanTL;
    private Double tienThu;


    private List<TaiSanResponse> taiSans;

    private UserResponse user;

    private Instant createdDate;


}
