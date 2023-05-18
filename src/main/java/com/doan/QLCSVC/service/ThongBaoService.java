package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongBaoRequest;
import com.doan.QLCSVC.dto.ThongBaoResponse;
import org.springframework.data.domain.Page;

public interface ThongBaoService {

    Page<ThongBaoResponse> getAllTB(ThongBaoRequest thongBaoRequest);
    Boolean addThongBao(ThongBaoRequest thongBaoRequest);
    Boolean updateThongBao(Long maThongBao);

}
