package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.*;
import com.doan.QLCSVC.service.ThongTinDCServiceImpl;
import com.doan.QLCSVC.service.ThongTinSuaServiceImpl;
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
@RequestMapping("QLCSVC/api/ttsua")
public class ThongTinSuaController {
    private final ThongTinSuaServiceImpl thongTinSuaService;

    @PostMapping("add")
    public ResponseEntity<Boolean> addTTDC(@RequestBody ThongTinSuaRequest thongTinSuaRequest){

        return ResponseEntity.ok().body(thongTinSuaService.addTTS(thongTinSuaRequest));

    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> getAll(@RequestBody ThongTinSuaRequest thongTinSuaRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",thongTinSuaService.getAllTTS(thongTinSuaRequest)) )
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("getTTSua")
    public ResponseEntity<ThongTinSuaResponse> getTTDC(@RequestBody ThongTinSuaRequest thongTinSuaRequest) {
        return ResponseEntity.ok().body(thongTinSuaService.getTTS(thongTinSuaRequest.getMaTTSua()));

    }

}
