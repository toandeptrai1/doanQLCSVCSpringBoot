package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.Instant;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongBaoRequest {
    private Long maThongBao;
    private String noiDung;
    private Instant createdDate;

    private User nguoiGui;
    private Long maNguoiGui;

    private User nguoiNhan;
    private Long maTTDC;
    private Long maTTSua;
    private Long maNguoiNhan;

    private Boolean read;

    private Integer page;
    private Integer size;
}
