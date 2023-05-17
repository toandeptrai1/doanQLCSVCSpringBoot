package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "thanhly")
public class ThongTinThanhLy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maThanhLy;
    private String tenThanhLy;
    private String moTa;
    private String coQuanTL;
    private Double tienThu;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<TaiSan> taiSans;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Instant createdDate;


}
