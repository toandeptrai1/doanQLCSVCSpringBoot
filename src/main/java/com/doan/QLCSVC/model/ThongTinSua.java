package com.doan.QLCSVC.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "thongtinsua")
public class ThongTinSua {
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
