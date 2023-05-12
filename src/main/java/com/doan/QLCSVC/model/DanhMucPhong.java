package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DanhMucPhong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDanhMucPhong;
    private String tenDanhMucPhong;



}
