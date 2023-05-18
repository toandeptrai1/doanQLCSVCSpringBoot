package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongTinDCRequest;
import com.doan.QLCSVC.dto.ThongTinDCResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.ThongTinDiChuyen;
import com.doan.QLCSVC.repo.PhongRepository;
import com.doan.QLCSVC.repo.TaiSanRepository;
import com.doan.QLCSVC.repo.ThongTinDiChuyenRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongTinDCServiceImpl implements ThongTinDCService{

    private final ThongTinDiChuyenRepo thongTinDiChuyenRepo;
    private final TaiSanRepository taiSanRepo;
    private final PhongRepository phongRepo;
    private final MapperService mapperService;

    @Override
    public ThongTinDCResponse addTTDC(ThongTinDCRequest thongTinDCRequest) {
        ThongTinDiChuyen thongTinDiChuyen= thongTinDiChuyenRepo.save(mapToTTDC(thongTinDCRequest));
        return mapToTTDCResponse(thongTinDiChuyen);
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
        Pageable pageable= PageRequest.of(thongTinDCRequest.getPage(),thongTinDCRequest.getSize());
        Page<ThongTinDiChuyen> page=thongTinDiChuyenRepo.findAll(pageable);
        Page<ThongTinDCResponse> pageTTDC=page.map(ttdc->mapToTTDCResponse(ttdc));
        return pageTTDC;
    }
    public ThongTinDCResponse mapToTTDCResponse(ThongTinDiChuyen thongTinDiChuyen){
        return ThongTinDCResponse.builder()
                .maTTDC(thongTinDiChuyen.getMaTTDC())
                .tenTTDC(thongTinDiChuyen.getTenTTDC())
                .createdDate(thongTinDiChuyen.getCreatedDate())
                .taiSans( thongTinDiChuyen.getTaiSans().stream().map(taiSan -> mapperService.mapToTaiSanResponse(taiSan)).collect(Collectors.toSet()))
                .user(mapperService.mapToUserResponse(thongTinDiChuyen.getUser()))
                .maPhongDC(thongTinDiChuyen.getMaPhongDC())
                .tenPhongDC(thongTinDiChuyen.getTenPhongDC())
                .maPhong(thongTinDiChuyen.getMaPhong())
                .moTa(thongTinDiChuyen.getMoTa())
                .tenPhong(thongTinDiChuyen.getTenPhong())
                .build();

    }

    @Override
    public ThongTinDCResponse getTTDC(Long maTTDC) {
        ThongTinDiChuyen thongTinDiChuyen=thongTinDiChuyenRepo.findById(maTTDC).orElseThrow();
        return mapToTTDCResponse(thongTinDiChuyen);
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
