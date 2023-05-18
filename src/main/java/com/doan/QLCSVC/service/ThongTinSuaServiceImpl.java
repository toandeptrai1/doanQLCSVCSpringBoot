package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongTinSuaRequest;
import com.doan.QLCSVC.dto.ThongTinSuaResponse;
import com.doan.QLCSVC.model.ThongTinSua;
import com.doan.QLCSVC.repo.ThongTinSuaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThongTinSuaServiceImpl implements ThongTinSuaService{

    private final ThongTinSuaRepo thongTinSuaRepo;
    private final MapperService mapperService;
    @Override
    public ThongTinSuaResponse addTTS(ThongTinSuaRequest thongTinSuaRequest) {
        ThongTinSua thongTinSua=thongTinSuaRepo.save(mapToThongTinSua(thongTinSuaRequest));
        return mapToTTSuaResponse(thongTinSua);
    }

    @Override
    public Page<ThongTinSuaResponse> getAllTTS(ThongTinSuaRequest thongTinSuaRequest) {
        Pageable pageable= PageRequest.of(thongTinSuaRequest.getPage(), thongTinSuaRequest.getSize());
        Page<ThongTinSua> page=thongTinSuaRepo.findAll(pageable);
        Page<ThongTinSuaResponse> pageTTS=page.map(this::mapToTTSuaResponse);

        return pageTTS;
    }
    public ThongTinSua mapToThongTinSua(ThongTinSuaRequest thongTinSuaRequest){
        return ThongTinSua.builder()
                .tenTTSua(thongTinSuaRequest.getTenTTSua())
                .user(thongTinSuaRequest.getUser())
                .chiPhi(thongTinSuaRequest.getChiPhi())
                .taiSans(thongTinSuaRequest.getTaiSans())
                .phong(thongTinSuaRequest.getPhong())
                .moTa(thongTinSuaRequest.getMoTa())
                .createdDate(Instant.now())
                .build();
    }
    public ThongTinSuaResponse mapToTTSuaResponse(ThongTinSua thongTinSua){
        return ThongTinSuaResponse.builder()
                .maTTSua(thongTinSua.getMaTTSua())
                .tenTTSua(thongTinSua.getTenTTSua())
                .moTa(thongTinSua.getMoTa())
                .phong(mapperService.mapToPhongResponse(thongTinSua.getPhong()))
                .taiSans(thongTinSua.getTaiSans().stream().map(mapperService::mapToTaiSanResponse).collect(Collectors.toList()))
                .chiPhi(thongTinSua.getChiPhi())
                .user(mapperService.mapToUserResponse(thongTinSua.getUser()))
                .createdDate(thongTinSua.getCreatedDate())
                .build();
    }

    @Override
    public ThongTinSuaResponse getTTS(Long maTTS) {
        if(thongTinSuaRepo.existsById(maTTS)){
            return mapToTTSuaResponse(thongTinSuaRepo.findById(maTTS).orElseThrow());
        }
        return null;
    }
}
