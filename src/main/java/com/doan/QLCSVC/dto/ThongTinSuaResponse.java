package com.doan.QLCSVC.dto;

import com.doan.QLCSVC.model.Phong;
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
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongTinSuaResponse {
    private Long maTTSua;
    private String tenTTSua;
    private String moTa;
    private Double chiPhi;
    private PhongResponse phong;

    private List<TaiSanResponse> taiSans;

    private UserResponse user;
    private Instant createdDate;

}
