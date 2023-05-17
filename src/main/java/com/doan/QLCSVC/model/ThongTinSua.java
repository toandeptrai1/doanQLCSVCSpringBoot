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
@Table(name = "thongtinsua")
public class ThongTinSua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTTSua;
    private String tenTTSua;
    private String moTa;
    private Double chiPhi;
    @ManyToOne(fetch = FetchType.LAZY)
    private Phong phong;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<TaiSan> taiSans;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Instant createdDate;




}
