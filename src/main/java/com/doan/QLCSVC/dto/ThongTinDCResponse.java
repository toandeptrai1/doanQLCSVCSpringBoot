package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThongTinDCResponse {
    private Long maTTDC;
    private String tenTTDC;
    private Long maPhongDC;
    private String tenPhongDC;
    private Long maPhong;
    private String tenPhong;

    private String moTa;
    private Instant createdDate;

    private Set<TaiSanResponse> taiSans;

    private UserResponse user;
}
