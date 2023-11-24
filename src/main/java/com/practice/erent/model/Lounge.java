package com.practice.erent.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Lounge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loungeType;
    private BigDecimal loungePrice;
    private Boolean isBooked = false;
    @Lob
    private Blob photo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedLounge> bookings;

    private Lounge(){
        this.bookings = new ArrayList<>();
    }

    public void addBooking(BookedLounge booking){
        if (booking == null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setLounge(this);
        isBooked = true;
        String bookingcode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingcode);

    }
}
