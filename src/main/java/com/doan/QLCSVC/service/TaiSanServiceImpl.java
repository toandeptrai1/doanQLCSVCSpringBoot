package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.PhongResponse;
import com.doan.QLCSVC.dto.TaiSanRequest;
import com.doan.QLCSVC.dto.TaiSanResponse;
import com.doan.QLCSVC.model.Phong;
import com.doan.QLCSVC.model.TaiSan;
import com.doan.QLCSVC.repo.PhongRepository;
import com.doan.QLCSVC.repo.TaiSanRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TaiSanServiceImpl implements TaiSanService{

    private final TaiSanRepository taiSanRepo;
    private final QRCodeService qrCodeService;
    private final PhongRepository phongRepo;


    @Override
    public Page<TaiSanResponse> getAllTS(Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<TaiSan> pageTaiSan=taiSanRepo.findAll(pageable);
        Page<TaiSanResponse> pageTSResponse=pageTaiSan.map(taisan->mapToTaiSanResponse(taisan));
        return pageTSResponse;
    }

    @Override
    public Page<TaiSanResponse> getTSByPhong(TaiSanRequest taiSanRequest) {
        Pageable pageable=PageRequest.of(taiSanRequest.getPage(), taiSanRequest.getSize());
        Phong phong=phongRepo.findById(taiSanRequest.getMaPhong()).orElseThrow();
        Page<TaiSan> pageTaiSan=taiSanRepo.findByPhong(phong,pageable);
        Page<TaiSanResponse> pageTSResponse=pageTaiSan.map(taisan->mapToTaiSanResponse(taisan));

        return pageTSResponse;
    }

    @Override
    public TaiSanResponse saveTS(TaiSanRequest taiSanRequest) {
        TaiSan taiSan=mapToTaiSan(taiSanRequest);
        try {
            taiSan.setImageQR(qrCodeService.generateQRCodeImage(taiSan));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mapToTaiSanResponse(taiSanRepo.save(taiSan));
    }

    @Override
    public TaiSanResponse getTSById(Long id) {
        return mapToTaiSanResponse(taiSanRepo.findById(id).orElseThrow());
    }

    @Override
    public Boolean deleteTaiSan(Long id) {
        if(taiSanRepo.existsById(id)){
            taiSanRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateTaiSan(TaiSanRequest taiSanRequest) {
        TaiSan taiSan=mapToTaiSan(taiSanRequest);
        if(taiSanRepo.existsById(taiSan.getMaTS())){
            try {
                taiSan.setImageQR(qrCodeService.generateQRCodeImage(taiSan));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            taiSanRepo.save(taiSan);
            return true;
        }
        return false;
    }

    @Override
    public Boolean diChuyenTS(TaiSanRequest taiSanRequest) {
        if(taiSanRepo.existsById(taiSanRequest.getMaTS())&& phongRepo.existsById(taiSanRequest.getMaPhongDC())){
            TaiSan taiSan=taiSanRepo.findById(taiSanRequest.getMaTS()).orElseThrow();
            Phong phong=phongRepo.findById(taiSanRequest.getMaPhongDC()).orElseThrow();
            taiSan.setPhong(phong);
            taiSanRepo.save(taiSan);
            return true;
        }
        return false;
    }

    public TaiSanResponse mapToTaiSanResponse(TaiSan taiSan){
        return TaiSanResponse.builder()
                .tenTS(taiSan.getTenTS())
                .maTS(taiSan.getMaTS())
                .trangThai(taiSan.getTrangThai())
                .danhMucTaiSan(taiSan.getDanhMucTaiSan())
                .hangSanXuat(taiSan.getHangSanXuat())
                .namSanXuat(taiSan.getNamSanXuat())
                .boMachChu(taiSan.getBoMachChu())
                .cacXuLyDoHoa(taiSan.getCacXuLyDoHoa())
                .congXuat(taiSan.getCongXuat())
                .image(taiSan.getImage())
                .imageQR(taiSan.getImageQR())
                .viSuLy(taiSan.getViSuLy())
                .khac(taiSan.getKhac())
                .boNho(taiSan.getBoNho())
                .phong(mapToPhongresponse(taiSan.getPhong()))
                .build();
    }
    public PhongResponse mapToPhongresponse(Phong phong){
        return PhongResponse.builder()
                .maPhong(phong.getMaPhong())
                .tenPhong(phong.getTenPhong())
                .build();

    }
    public TaiSan mapToTaiSan(TaiSanRequest taiSanRequest){
        Phong phong=phongRepo.findById(taiSanRequest.getMaPhong()).orElseThrow();

        return TaiSan.builder()
                .maTS(taiSanRequest.getMaTS())
                .tenTS(taiSanRequest.getTenTS())
                .trangThai(taiSanRequest.getTrangThai())
                .danhMucTaiSan(taiSanRequest.getDanhMucTaiSan())
                .image(taiSanRequest.getImage())
                .imageQR(taiSanRequest.getImageQR())
                .namSanXuat(taiSanRequest.getNamSanXuat())
                .hangSanXuat(taiSanRequest.getHangSanXuat())
                .phong(phong)
                .boNho(taiSanRequest.getBoNho())
                .boMachChu(taiSanRequest.getBoMachChu())
                .cacXuLyDoHoa(taiSanRequest.getCacXuLyDoHoa())
                .khac(taiSanRequest.getKhac())
                .congXuat(taiSanRequest.getCongXuat())
                .viSuLy(taiSanRequest.getViSuLy())

                .build();

    }


}
