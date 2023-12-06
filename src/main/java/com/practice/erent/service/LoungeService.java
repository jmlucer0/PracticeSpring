package com.practice.erent.service;

import com.practice.erent.model.Lounge;
import com.practice.erent.repository.LoungeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoungeService implements ILoungeService{

    @Autowired
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

    @Override
    public List<String> getAllLoungesTypes() {
        return loungeRepository.findDistinctLoungeTypes();
    }
}
