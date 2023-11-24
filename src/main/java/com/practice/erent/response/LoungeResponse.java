package com.practice.erent.response;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class LoungeResponse {

    private Long id;
    private String loungeType;
    private BigDecimal loungePrice;
    private Boolean isBooked = false;
    private String photo;
    private List<BookingResponse> bookings;

    public LoungeResponse(Long id, String loungeType, BigDecimal loungePrice) {
        this.id = id;
        this.loungeType = loungeType;
        this.loungePrice = loungePrice;
    }

    public LoungeResponse(Long id, String loungeType, BigDecimal loungePrice, Boolean isBooked, byte[] photoBytes, List<BookingResponse> bookings) {
        this.id = id;
        this.loungeType = loungeType;
        this.loungePrice = loungePrice;
        this.isBooked = isBooked;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
        this.bookings = bookings;
    }
}
