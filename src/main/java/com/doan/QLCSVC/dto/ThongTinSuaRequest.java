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
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongTinSuaRequest {
    private Long maTTSua;
    private String tenTTSua;
    private String moTa;
    private Double chiPhi;

    private List<TaiSan> taiSans;
    private Integer page;
    private Integer size;
    private Phong phong;

    private User user;
}
