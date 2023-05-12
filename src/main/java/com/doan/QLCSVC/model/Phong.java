package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Phong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPhong;
    private String tenPhong;
    private Float chieuDai;
    private Float chieuRong;
    private String vitri;
    private String image;
    private String mota;


    @ManyToOne(fetch = FetchType.EAGER)
    private TrangThai trangThai;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maDanhMucPhong",referencedColumnName = "maDanhMucPhong")
    private DanhMucPhong danhMucPhong;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "phongs")
    private List<User> users;




}
