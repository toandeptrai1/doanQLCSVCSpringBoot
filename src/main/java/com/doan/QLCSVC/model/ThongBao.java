package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ThongBao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maThongBao;
    private String noiDung;
    private Instant createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User nguoiGui;
    @ManyToOne(fetch = FetchType.LAZY)
    private User nguoiNhan;
    private Long maTTDC;
    private Long maTTSua;


}
