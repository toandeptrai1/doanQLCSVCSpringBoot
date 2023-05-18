package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongBaoResponse {
    private Long maThongBao;
    private String noiDung;
    private Instant createdDate;

    private UserResponse nguoiGui;

    private UserResponse nguoiNhan;
    private Long maTTDC;
    private Long maTTSua;
    private String duration;

    private Boolean read;

}
