package com.doan.QLCSVC.service;


import com.doan.QLCSVC.dto.ThongTinTLRequest;
import com.doan.QLCSVC.dto.ThongTinTLResponse;

import com.doan.QLCSVC.model.ThongTinThanhLy;

import com.doan.QLCSVC.repo.ThongTinThanhLyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongTinThanhLyServiceImpl implements ThongTinThanhLyService{

    private final ThongTinThanhLyRepo thongTinThanhLyRepo;
    private final MapperService mapperService;
    @Override
    public Boolean addTTTL(ThongTinTLRequest thongTinTLRequest) {
        ThongTinThanhLy thongTinThanhLy = thongTinThanhLyRepo.save(mapToThongTinThanhLy(thongTinTLRequest));
        return true;
    }

    @Override
    public Page<ThongTinTLResponse> getAllTTTL(ThongTinTLRequest thongTinTLRequest) {
        Pageable pageable= PageRequest.of(thongTinTLRequest.getPage(), thongTinTLRequest.getSize());
        Page<ThongTinThanhLy> page=thongTinThanhLyRepo.findAll(pageable);
        Page<ThongTinTLResponse> pageTTS=page.map(this::mapToTTTLResponse);

        return pageTTS;
    }
    public ThongTinThanhLy mapToThongTinThanhLy(ThongTinTLRequest thongTinTLRequest){
        return ThongTinThanhLy.builder()
                .tenThanhLy(thongTinTLRequest.getTenThanhLy())
                .user(thongTinTLRequest.getUser())
                .tienThu(thongTinTLRequest.getTienThu())
                .taiSans(thongTinTLRequest.getTaiSans())
                .moTa(thongTinTLRequest.getMoTa())
                .coQuanTL(thongTinTLRequest.getCoQuanTL())
                .createdDate(Instant.now())
                .build();
    }
    public ThongTinTLResponse mapToTTTLResponse(ThongTinThanhLy thongTinThanhLy){
        return ThongTinTLResponse.builder()
                .maThanhLy(thongTinThanhLy.getMaThanhLy())
                .tenThanhLy(thongTinThanhLy.getTenThanhLy())
                .moTa(thongTinThanhLy.getMoTa())
                .taiSans(thongTinThanhLy.getTaiSans().stream().map(mapperService::mapToTaiSanResponse).collect(Collectors.toList()))
                .tienThu(thongTinThanhLy.getTienThu())
                .user(mapperService.mapToUserResponse(thongTinThanhLy.getUser()))
                .createdDate(thongTinThanhLy.getCreatedDate())
                .coQuanTL(thongTinThanhLy.getCoQuanTL())
                .build();
    }

    @Override
    public ThongTinTLResponse getTTTL(Long maTL) {
        if(thongTinThanhLyRepo.existsById(maTL)){
            return mapToTTTLResponse(thongTinThanhLyRepo.findById(maTL).orElseThrow());
        }
        return null;
    }
}
