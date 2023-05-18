package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongBaoRequest;
import com.doan.QLCSVC.dto.ThongBaoResponse;
import com.doan.QLCSVC.model.ThongBao;
import com.doan.QLCSVC.model.User;
import com.doan.QLCSVC.repo.ThongBaoReposiroty;
import com.doan.QLCSVC.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ThongBaoServiceImpl implements ThongBaoService{
    private final ThongBaoReposiroty thongBaoRepo;
    private final MapperService mapperService;
    private final UserRepository userRepository;
    @Override
    public Page<ThongBaoResponse> getAllTB(ThongBaoRequest thongBaoRequest) {
        Pageable pageable= PageRequest.of(thongBaoRequest.getPage(), thongBaoRequest.getSize(),
                Sort.by("createdDate").descending());
        Page<ThongBao> page=thongBaoRepo.findAll(pageable);
        Page<ThongBaoResponse> pageTB=page.map(this::mapToThongBaoReq);
        return pageTB;
    }

    @Override
    public Boolean addThongBao(ThongBaoRequest thongBaoRequest) {

        if( userRepository.existsById(thongBaoRequest.getMaNguoiGui())&&
                userRepository.existsById(thongBaoRequest.getMaNguoiNhan()))
        {
            User nguoiGui=userRepository.findById(thongBaoRequest.getMaNguoiGui()).orElseThrow();
            User nguoiNhan=userRepository.findById(thongBaoRequest.getMaNguoiNhan()).orElseThrow();
            thongBaoRequest.setNguoiGui(nguoiGui);
            thongBaoRequest.setNguoiNhan(nguoiNhan);
            thongBaoRepo.save(mapToThongBao(thongBaoRequest));

            return true;
        }
        return false;
    }


    @Override
    public Boolean updateThongBao(Long maThongBao) {
        return null;
    }
    private  String getDuration(Date pastTime) {
        PrettyTime prettyTime = new PrettyTime();
        return prettyTime.format(pastTime);
    }
    public ThongBaoResponse mapToThongBaoReq(ThongBao thongBao){
        return ThongBaoResponse.builder()
                .duration(getDuration(Date.from(thongBao.getCreatedDate())))
                .maThongBao(thongBao.getMaThongBao())
                .noiDung(thongBao.getNoiDung())
                .createdDate(thongBao.getCreatedDate())
                .nguoiGui(mapperService.mapToUserResponse(thongBao.getNguoiGui()))
                .nguoiNhan(mapperService.mapToUserResponse(thongBao.getNguoiNhan()))
                .maTTDC(thongBao.getMaTTDC())
                .maTTSua(thongBao.getMaTTSua())
                .build();

    }

    public ThongBao mapToThongBao(ThongBaoRequest thongBaoRequest){

        return ThongBao.builder()
                .noiDung(thongBaoRequest.getNoiDung())
                .createdDate(Instant.now())
                .nguoiGui(thongBaoRequest.getNguoiGui())
                .nguoiNhan(thongBaoRequest.getNguoiNhan())
                .maTTDC(thongBaoRequest.getMaTTDC())
                .maTTSua(thongBaoRequest.getMaTTSua())
                .build();
    }
}
