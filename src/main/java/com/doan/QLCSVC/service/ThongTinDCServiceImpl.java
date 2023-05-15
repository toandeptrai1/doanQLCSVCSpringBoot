package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongTinDCRequest;
import com.doan.QLCSVC.dto.ThongTinDCResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.model.ThongTinDiChuyen;
import com.doan.QLCSVC.repo.PhongRepository;
import com.doan.QLCSVC.repo.TaiSanRepository;
import com.doan.QLCSVC.repo.ThongTinDiChuyenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ThongTinDCServiceImpl implements ThongTinDCService{

    private final ThongTinDiChuyenRepo thongTinDiChuyenRepo;
    private final TaiSanRepository taiSanRepo;
    private final PhongRepository phongRepo;
    @Override
    public Boolean addTTDC(ThongTinDCRequest thongTinDCRequest) {
        thongTinDiChuyenRepo.save(mapToTTDC(thongTinDCRequest));
        return true;
    }

    @Override
    public Boolean deleteTTDC(Long maTTDC) {
        return null;
    }

    @Override
    public Boolean updateTTDC(ThongTinDCRequest thongTinDCRequest) {
        return null;
    }

    @Override
    public Page<ThongTinDCResponse> getAllTTDC(ThongTinDCRequest thongTinDCRequest) {
        return null;
    }

    @Override
    public ThongTinDCResponse getTTDC(Long maTTDC) {
        return null;
    }
    public ThongTinDiChuyen mapToTTDC(ThongTinDCRequest thongTinDCRequest){
        Phong phong=phongRepo.findById(thongTinDCRequest.getMaPhong()).orElseThrow();
        Phong phongDC=phongRepo.findById(thongTinDCRequest.getMaPhongDC()).orElseThrow();
        return ThongTinDiChuyen.builder()
                .tenTTDC(thongTinDCRequest.getTenTTDC())

                .createdDate(Instant.now())
                .taiSans(thongTinDCRequest.getTaiSans())
                .user(thongTinDCRequest.getUser())
                .maPhong(thongTinDCRequest.getMaPhong())
                .tenPhong(thongTinDCRequest.getTenPhong())
                .maPhongDC(phong.getMaPhong())
                .tenPhong(phong.getTenPhong())
                .maPhongDC(phongDC.getMaPhong())
                .tenPhongDC(phongDC.getTenPhong())
                .moTa(thongTinDCRequest.getMoTa())
                .build();
    }
}
