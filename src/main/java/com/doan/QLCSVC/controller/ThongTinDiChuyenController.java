package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ApiResponse;
import com.doan.QLCSVC.dto.ThongTinDCRequest;
import com.doan.QLCSVC.dto.ThongTinDCResponse;
import com.doan.QLCSVC.service.ThongTinDCServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequiredArgsConstructor
@RequestMapping("QLCSVC/api/ttdc")
public class ThongTinDiChuyenController {
    private final ThongTinDCServiceImpl thongTinDCService;

    @PostMapping("add")
    public ResponseEntity<Boolean> addTTDC(@RequestBody ThongTinDCRequest thongTinDCRequest){

        return ResponseEntity.ok().body(thongTinDCService.addTTDC(thongTinDCRequest));

    }

    @PostMapping("")
    public ResponseEntity<ApiResponse> getAll(@RequestBody ThongTinDCRequest thongTinDCRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",thongTinDCService.getAllTTDC(thongTinDCRequest)) )
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("getTTDC")
    public ResponseEntity<ThongTinDCResponse> getTTDC(@RequestBody ThongTinDCRequest thongTinDCRequest) {
        return ResponseEntity.ok().body(thongTinDCService.getTTDC(thongTinDCRequest.getMaTTDC()));

    }

}
