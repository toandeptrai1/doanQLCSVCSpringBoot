package com.doan.QLCSVC.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
public class CaTruc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maCatruc;
    private String tenCaTruc;
    private Instant timeStart;
    private Instant timeEnd;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "maTS")
    private  TaiSan taiSan;




}
