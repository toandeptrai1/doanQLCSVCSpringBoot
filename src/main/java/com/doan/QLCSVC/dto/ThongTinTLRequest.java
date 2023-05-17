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
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThongTinTLRequest {
    private Long maThanhLy;
    private String tenThanhLy;
    private String moTa;
    private String coQuanTL;
    private Double tienThu;


    private List<TaiSan> taiSans;

    private User user;

    private Instant createdDate;
    private Integer page;
    private Integer size;


}
