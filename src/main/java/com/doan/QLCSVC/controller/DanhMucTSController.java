package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.model.DanhMucTaiSan;
import com.doan.QLCSVC.service.DanhMucTSServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("QLCSVC/api/danhmucTS")
public class DanhMucTSController {
    private final DanhMucTSServiceImpl danhMucTSService;
    @GetMapping("")
    public ResponseEntity<List<DanhMucTaiSan>> getAll(){
        return ResponseEntity.ok().body(danhMucTSService.getAll());
    }
}
