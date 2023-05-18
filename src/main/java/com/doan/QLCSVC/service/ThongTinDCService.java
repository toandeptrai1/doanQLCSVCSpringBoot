package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongTinDCRequest;
import com.doan.QLCSVC.dto.ThongTinDCResponse;
import com.doan.QLCSVC.model.ThongTinDiChuyen;
import org.springframework.data.domain.Page;

public interface ThongTinDCService {
    ThongTinDCResponse addTTDC(ThongTinDCRequest thongTinDCRequest);
    Boolean deleteTTDC(Long maTTDC);
    Boolean updateTTDC(ThongTinDCRequest thongTinDCRequest);

    Page<ThongTinDCResponse> getAllTTDC(ThongTinDCRequest thongTinDCRequest);

    ThongTinDCResponse getTTDC(Long maTTDC);

}
