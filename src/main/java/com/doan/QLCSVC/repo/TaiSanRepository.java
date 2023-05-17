package com.doan.QLCSVC.repo;

import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.model.TrangThai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface TaiSanRepository extends JpaRepository<TaiSan,Long> {
    Page<TaiSan> findByPhong(Phong phong, Pageable pageable);

    Page<TaiSan> findByPhongAndTrangThai(Phong phong, TrangThai trangThai,Pageable pageable);


}
