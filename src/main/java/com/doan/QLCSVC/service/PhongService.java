package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.PhongRequest;
import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.model.Phong;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PhongService {
    PhongResponse addPhong(PhongRequest phongRequest);
    Page<PhongResponse> getPhongs(PhongRequest phongRequest);
    PhongResponse getPhong(Long id);
    List<PhongResponse> getAllPhong();
    Boolean updatePhong(PhongRequest phongRequest);
    Boolean deletePhong(PhongRequest phongRequest);
}
