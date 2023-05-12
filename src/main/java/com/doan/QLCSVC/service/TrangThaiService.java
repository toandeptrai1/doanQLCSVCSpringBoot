package com.doan.QLCSVC.service;

import com.doan.QLCSVC.model.TrangThai;
import com.doan.QLCSVC.repo.TrangThaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrangThaiService {
    private final TrangThaiRepository trangThaiRepo;
    public List<TrangThai> getTrangThais(){
        return trangThaiRepo.findAll();
    }
}
