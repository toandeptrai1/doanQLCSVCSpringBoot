package com.doan.QLCSVC.service;


import com.doan.QLCSVC.dto.ThongTinTLRequest;
import com.doan.QLCSVC.dto.ThongTinTLResponse;
import org.springframework.data.domain.Page;

public interface ThongTinThanhLyService {
    Boolean addTTTL(ThongTinTLRequest thongTinTLRequest);
    Page<ThongTinTLResponse> getAllTTTL(ThongTinTLRequest thongTinTLRequest);
    ThongTinTLResponse getTTTL(Long maTL);


}
