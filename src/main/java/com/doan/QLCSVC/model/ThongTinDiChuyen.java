package com.doan.QLCSVC.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@Table(name = "thongtindichuyen")
public class ThongTinDiChuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTTSua;
    private String tenTTSua;
    private String moTa;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<TaiSan> taiSans;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
