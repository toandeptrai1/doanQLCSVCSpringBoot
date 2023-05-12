package com.doan.QLCSVC.controller;

import com.doan.QLCSVC.dto.ApiResponse;
import com.doan.QLCSVC.dto.PhongRequest;
import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.model.DanhMucPhong;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.service.DanhMucPhongServiceImpl;
import com.doan.QLCSVC.service.PhongServiceImpl;
import com.doan.QLCSVC.service.QRCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("QLCSVC/api/phong")
@RequiredArgsConstructor
public class PhongController {
    private final PhongServiceImpl phongService;
    private final QRCodeService qrCodeService;

    private final DanhMucPhongServiceImpl danhMucPhongService;

    @PostMapping("/add")
    public ResponseEntity<PhongResponse> addPhong(@RequestBody PhongRequest phongRequest){

        return  ResponseEntity.ok().body(phongService.addPhong(phongRequest));


    }
    @GetMapping(value = "")
    public ResponseEntity<List<PhongResponse>> getAllPhong(){
        return ResponseEntity.ok().body(phongService.getAllPhong());
    }
    @PostMapping(value = "/getAll")
    public ResponseEntity<?> getPhongs(@RequestBody PhongRequest phongRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",phongService.getPhongs(phongRequest)) )
                .build();


        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/update")
    public ResponseEntity<Boolean> updatePhong(@RequestBody PhongRequest phongRequest){

        return ResponseEntity.ok().body(phongService.updatePhong(phongRequest));
    }
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deletePhong(@RequestBody PhongRequest phongRequest){

        return ResponseEntity.ok().body(phongService.deletePhong(phongRequest));
    }
    @GetMapping("getPhong/{id}")
    public ResponseEntity<PhongResponse> getPhong(@PathVariable Long id){
        return ResponseEntity.ok().body(phongService.getPhong(id));
    }
    @GetMapping("danhmucs")
    public ResponseEntity<List<DanhMucPhong>> getDanhMucPhongs(){
        return ResponseEntity.ok().body(danhMucPhongService.getDMPhongs());
    }


}
