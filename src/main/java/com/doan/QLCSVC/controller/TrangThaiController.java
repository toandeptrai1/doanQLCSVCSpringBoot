package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.model.TrangThai;
import com.doan.QLCSVC.service.TrangThaiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("QLCSVC/api/trangthai")
@RequiredArgsConstructor
public class TrangThaiController {
    private final TrangThaiService trangThaiService;
    @GetMapping("getAll")
    public ResponseEntity<List<TrangThai>> getTrangThais(){
        return ResponseEntity.ok().body(trangThaiService.getTrangThais());
    }
}
