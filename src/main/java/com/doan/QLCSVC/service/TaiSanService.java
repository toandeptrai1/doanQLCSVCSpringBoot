package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.TaiSanRequest;
import com.doan.QLCSVC.dto.TaiSanResponse;
import com.doan.QLCSVC.model.TaiSan;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TaiSanService {
    Page<TaiSanResponse> getAllTS(Integer page, Integer size);

    Page<TaiSanResponse> getTSByPhong(TaiSanRequest taiSanRequest);
    TaiSanResponse saveTS(TaiSanRequest taiSanRequest);
    TaiSanResponse getTSById(Long id);
    Boolean deleteTaiSan(Long id);
    Boolean updateTaiSan(TaiSanRequest taiSanRequest);

}
