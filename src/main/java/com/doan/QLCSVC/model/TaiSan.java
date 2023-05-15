package com.doan.QLCSVC.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaiSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTS;
    private String tenTS;

    private String namSanXuat;
    private String hangSanXuat;
    private String image;
    private String imageQR;

    //Thong so
    private String boNho;
    private String viSuLy;
    private String boMachChu;
    private String cacXuLyDoHoa;
    private String khac;
    private String congXuat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "danhMucTS_id")
    private DanhMucTaiSan danhMucTaiSan;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MaTT")
    private  TrangThai trangThai;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maPhong",referencedColumnName = "maPhong")
    private Phong phong;

    @Override
    public String toString() {
        return "TaiSan{" +
                "maTS=" + maTS +
                ", tenTS='" + tenTS + '\'' +
                ", namSanXuat='" + namSanXuat + '\'' +
                ", hangSanXuat='" + hangSanXuat + '\'' +
                ", image='" + image + '\'' +
                ", imageQR='" + imageQR + '\'' +
                ", boNho='" + boNho + '\'' +
                ", viSuLy='" + viSuLy + '\'' +
                ", boMachChu='" + boMachChu + '\'' +
                ", cacXuLyDoHoa='" + cacXuLyDoHoa + '\'' +
                ", khac='" + khac + '\'' +
                ", congXuat='" + congXuat + '\'' +
                ", danhMucTaiSan=" + danhMucTaiSan +
                ", trangThai=" + trangThai +

                '}';
    }
}
