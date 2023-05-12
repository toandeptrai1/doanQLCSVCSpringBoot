package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DanhMucTaiSan")
public class DanhMucTaiSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDanhMucTS")
    private Long maDanhMucTS;
    @Column(name = "tenDanhMucTS")
    private String tenDanhMucTS;



}
