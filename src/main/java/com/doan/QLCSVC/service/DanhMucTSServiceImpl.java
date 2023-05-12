package com.doan.QLCSVC.service;

import com.doan.QLCSVC.model.DanhMucTaiSan;
import com.doan.QLCSVC.repo.DanhMucTSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucTSServiceImpl implements DanhMucTSService {
    private final DanhMucTSRepository danhMucTSRepo;
    @Override
    public List<DanhMucTaiSan> getAll() {
        return danhMucTSRepo.findAll();
    }
}
