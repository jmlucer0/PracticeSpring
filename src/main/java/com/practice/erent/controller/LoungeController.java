package com.practice.erent.controller;

import com.practice.erent.model.Lounge;
import com.practice.erent.response.LoungeResponse;
import com.practice.erent.service.ILoungeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lounges")
public class LoungeController {

    @Autowired
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

    @GetMapping("/lounge/types")
    public List<String> getLoungeTypes(){
        return loungeService.getAllLoungesTypes();
    }

    public ResponseEntity<List<Lounge>> getAllLounges(){
        List<Lounge> lounges =  loungeService.getAllLounges();
        List<LoungeResponse> loungeResponses = new ArrayList<>();
        for(Lounge lounge : lounges){
            byte[]
        }
    }
}
