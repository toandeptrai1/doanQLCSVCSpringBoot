package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.PhongRequest;
import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.dto.UserResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.User;
import com.doan.QLCSVC.repo.PhongRepository;
import com.doan.QLCSVC.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhongServiceImpl implements PhongService{
    private final PhongRepository phongRepo;
    private final UserRepository userRepo;
    @Override
    public PhongResponse addPhong(PhongRequest phongRequest) {
        Phong phong=mapToPhong(phongRequest);
        return mapToPhongResponse(phongRepo.save(phong));
    }

    @Override
    public Page<PhongResponse> getPhongs(PhongRequest phongRequest) {
        Pageable pageable= PageRequest.of(phongRequest.getPage(), phongRequest.getSize());
        Page<Phong> pagePhong=phongRepo.findAll(pageable);
        Page<PhongResponse> pagePhongResponse=pagePhong.map(phong->mapToPhongResponse(phong));
        return pagePhongResponse;
    }

    @Override
    public PhongResponse getPhong(Long id) {
        return mapToPhongResponse(phongRepo.findById(id).orElseThrow());
    }

    @Override
    public List<PhongResponse> getAllPhong() {
        return phongRepo.findAll().stream().map(this::mapToPhongResponse).collect(Collectors.toList());
    }

    @Override
    public Boolean updatePhong(PhongRequest phongRequest) {
        if(phongRepo.existsById(phongRequest.getMaPhong())){



            phongRepo.save(mapToPhong(phongRequest));
            return true;
        }
        return false;
    }

    @Override
    public Boolean deletePhong(PhongRequest phongRequest) {

        if(phongRepo.existsById(phongRequest.getMaPhong())){
            phongRepo.deleteById(phongRequest.getMaPhong());
            return true;
        }

        return false;
    }

    private PhongResponse mapToPhongResponse(Phong phong){
        return  PhongResponse.builder()
                .vitri(phong.getVitri())
                .mota(phong.getMota())
                .maPhong(phong.getMaPhong())
                .tenPhong(phong.getTenPhong())
                .image(phong.getImage())
                .chieuRong(phong.getChieuRong())
                .chieuDai(phong.getChieuDai())
                .users(phong.getUsers().stream().map(this::mapToUserResponse).collect(Collectors.toList()))
                .trangThai(phong.getTrangThai())
                .danhMucPhong(phong.getDanhMucPhong())
                .trangThai(phong.getTrangThai())
                .build();
    }

    private UserResponse mapToUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .username(user.getUsername())
                .chucVu(user.getChucVu())
                .image(user.getImage())
                .phone(user.getPhone())
                .email(user.getEmail())
                .roles(user.getRoles())
                .build();
    }



    private Phong mapToPhong(PhongRequest phongRequest){
        return Phong.builder()
                .maPhong(phongRequest.getMaPhong())
                .tenPhong(phongRequest.getTenPhong())
                .chieuDai(phongRequest.getChieuDai())
                .image(phongRequest.getImage())
                .mota(phongRequest.getMota())
                .chieuRong(phongRequest.getChieuRong())
                .vitri(phongRequest.getVitri())
                .trangThai(phongRequest.getTrangThai())
                .danhMucPhong(phongRequest.getDanhMucPhong())
                .build();
    }
}
