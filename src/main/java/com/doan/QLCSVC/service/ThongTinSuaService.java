package com.doan.QLCSVC.service;

import com.doan.QLCSVC.dto.ThongTinSuaRequest;
import com.doan.QLCSVC.dto.ThongTinSuaResponse;
import org.springframework.data.domain.Page;

public interface ThongTinSuaService {
    ThongTinSuaResponse addTTS(ThongTinSuaRequest thongTinSuaRequest);
    Page<ThongTinSuaResponse> getAllTTS(ThongTinSuaRequest thongTinSuaRequest);
    ThongTinSuaResponse getTTS(Long maTTS);


}
