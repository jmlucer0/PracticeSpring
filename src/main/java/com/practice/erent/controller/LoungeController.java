package com.practice.erent.controller;

import com.practice.erent.model.Lounge;
import com.practice.erent.response.LoungeResponse;
import com.practice.erent.service.ILoungeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lounges")
public class LoungeController {
    private final ILoungeService loungeService;

    @PostMapping("/add/new-lounge")
    public ResponseEntity<LoungeResponse> addNewLounge(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("loungeType") String loungeType,
            @RequestParam("loungePrice") BigDecimal loungePrice) throws SQLException, IOException {
        Lounge savedLounge = loungeService.addNewLounge(photo, loungeType, loungePrice);
        LoungeResponse response = new LoungeResponse(savedLounge.getId(), savedLounge.getLoungeType(), savedLounge.getLoungePrice());
        return ResponseEntity.ok(response);
    }
}
