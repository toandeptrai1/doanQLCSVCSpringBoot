package com.doan.QLCSVC.service;

import com.doan.QLCSVC.model.ChucVu;
import com.doan.QLCSVC.repo.ChucVuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChucVuServiceImpl implements ChucVuService{

    private final ChucVuRepository chucVuRepo;

    @Override
    public List<ChucVu> getChucVus() {
        return chucVuRepo.findAll();
    }
}
