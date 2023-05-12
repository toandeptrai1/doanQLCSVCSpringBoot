package com.doan.QLCSVC.service;

import com.doan.QLCSVC.model.DanhMucPhong;
import com.doan.QLCSVC.repo.DanhMucPhongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DanhMucPhongServiceImpl implements DanhMucPhongService{
    private final DanhMucPhongRepo danhMucPhongRepo;
    @Override
    public List<DanhMucPhong> getDMPhongs() {
        return danhMucPhongRepo.findAll();
    }
}
