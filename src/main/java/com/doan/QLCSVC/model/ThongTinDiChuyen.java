package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "thongtindichuyen")
public class ThongTinDiChuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTTDC;
    private String tenTTDC;
    private Long maPhongDC;
    private String tenPhongDC;
    private Long maPhong;
    private String tenPhong;

    private String moTa;
    private Instant createdDate;
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<TaiSan> taiSans;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
