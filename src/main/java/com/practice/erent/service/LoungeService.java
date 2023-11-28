package com.practice.erent.service;

import com.practice.erent.model.Lounge;
import com.practice.erent.repository.LoungeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class LoungeService implements ILoungeService{

    private final LoungeRepository loungeRepository;

    @Override
    public Lounge addNewLounge(MultipartFile file, String loungeType, BigDecimal loungePrice) throws SQLException, IOException {
        Lounge lounge = new Lounge();
        lounge.setLoungeType(loungeType);
        lounge.setLoungePrice(loungePrice);
        if(!file.isEmpty()){
            byte[] photoBytes = file.getBytes();
            Blob photoBlob = new SerialBlob(photoBytes);
            lounge.setPhoto(photoBlob);
        }
        return loungeRepository.save(lounge);
    }
}
