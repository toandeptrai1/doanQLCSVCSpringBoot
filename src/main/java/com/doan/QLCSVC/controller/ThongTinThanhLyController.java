package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.*;
import com.doan.QLCSVC.service.ThongTinSuaServiceImpl;
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
@RequestMapping("QLCSVC/api/ttthanhly")
public class ThongTinThanhLyController {
    private final ThongTinThanhLyServiceImpl thongTinThanhLyService;

    @PostMapping("add")
    public ResponseEntity<Boolean> addTTDC(@RequestBody ThongTinTLRequest thongTinTLRequest){

        return ResponseEntity.ok().body(thongTinThanhLyService.addTTTL(thongTinTLRequest));

    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> getAll(@RequestBody ThongTinTLRequest thongTinTLRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",thongTinThanhLyService.getAllTTTL(thongTinTLRequest)) )
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("getTTTL")
    public ResponseEntity<ThongTinTLResponse> getTTDC(@RequestBody ThongTinTLRequest thongTinTLRequest) {
        return ResponseEntity.ok().body(thongTinThanhLyService.getTTTL(thongTinTLRequest.getMaThanhLy()));

    }

}
