package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ThongTinDCRequest;
import com.doan.QLCSVC.service.ThongTinDCServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("QLCSVC/api/ttdc")
public class ThongTinDiChuyenController {
    private final ThongTinDCServiceImpl thongTinDCService;

    @PostMapping("add")
    public ResponseEntity<Boolean> addTTDC(@RequestBody ThongTinDCRequest thongTinDCRequest){

        return ResponseEntity.ok().body(thongTinDCService.addTTDC(thongTinDCRequest));

    }



}
