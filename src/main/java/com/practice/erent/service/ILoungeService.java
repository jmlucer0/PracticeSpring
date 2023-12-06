package com.practice.erent.service;

import com.practice.erent.model.Lounge;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ILoungeService {
    Lounge addNewLounge(MultipartFile photo, String loungeType, BigDecimal loungePrice) throws SQLException, IOException;

    List<String> getAllLoungesTypes();

}
