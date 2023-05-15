package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ApiResponse;
import com.doan.QLCSVC.dto.TaiSanRequest;
import com.doan.QLCSVC.dto.TaiSanResponse;
import com.doan.QLCSVC.model.TaiSan;

import com.doan.QLCSVC.service.TaiSanServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("QLCSVC/api/taisan")
@RequiredArgsConstructor
public class TaiSanController {
    private final TaiSanServiceImpl taiSanService;

    @PostMapping("add")
    public ResponseEntity<TaiSanResponse> addTS(@RequestBody TaiSanRequest taiSan){
        return ResponseEntity.ok().body(taiSanService.saveTS(taiSan));
    }
    @GetMapping("getTS/{id}")
    public ResponseEntity<TaiSanResponse> getTS(@PathVariable Long id){
        return ResponseEntity.ok().body(taiSanService.getTSById(id));
    }
    @PostMapping("")
    public ResponseEntity<ApiResponse> getAll(@RequestBody TaiSanRequest taiSanRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",taiSanService.getAllTS(taiSanRequest.getPage(), taiSanRequest.getSize())) )
                .build();
        return ResponseEntity.ok().body(apiResponse);

    }

    @PostMapping("delete")
    public ResponseEntity<Boolean> deleteTS(@RequestBody Long id){
        return ResponseEntity.ok().body(taiSanService.deleteTaiSan(id));
    }

    @PostMapping("update")
    public ResponseEntity<Boolean> updateTS(@RequestBody TaiSanRequest taiSan){
        return  ResponseEntity.ok().body(taiSanService.updateTaiSan(taiSan));
    }
    @PostMapping("getTSByPhong")
    public  ResponseEntity<ApiResponse> getTSByPhong(@RequestBody TaiSanRequest taiSanRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",taiSanService.getTSByPhong(taiSanRequest)) )
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("dichuyen")
    public ResponseEntity<Boolean> diChuyenTS(@RequestBody TaiSanRequest taiSanRequest){
        return ResponseEntity.ok().body(taiSanService.diChuyenTS(taiSanRequest));
    }






}
