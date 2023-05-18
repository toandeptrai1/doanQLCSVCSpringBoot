package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ApiResponse;
import com.doan.QLCSVC.dto.ThongBaoRequest;
import com.doan.QLCSVC.dto.ThongTinTLRequest;
import com.doan.QLCSVC.dto.ThongTinTLResponse;
import com.doan.QLCSVC.service.ThongBaoServiceImpl;
import com.doan.QLCSVC.service.ThongTinThanhLyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("QLCSVC/api/thongbao")
public class ThongBaoController {
    private final ThongBaoServiceImpl thongBaoService;

    @PostMapping("add")
    public ResponseEntity<Boolean> addTTDC(@RequestBody ThongBaoRequest thongBaoRequest){

        return ResponseEntity.ok().body(thongBaoService.addThongBao(thongBaoRequest));

    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> getAll(@RequestBody ThongBaoRequest thongBaoRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",thongBaoService.getAllTB(thongBaoRequest)) )
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }


}
