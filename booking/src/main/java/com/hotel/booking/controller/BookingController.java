package com.hotel.booking.controller;

import com.hotel.base.dto.BookingEventDTO;
import com.hotel.booking.common.BookingResponse;
import com.hotel.booking.dto.BookingDTO;
import com.hotel.booking.kafka.BookingProducer;
import com.hotel.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value ="/api/booking/")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingProducer bookingProducer;

    @PostMapping("/addbooking")
    public BookingResponse addBooking(@RequestBody  BookingDTO bookingDTO){
        BookingEventDTO bookingEventDTO = new BookingEventDTO();
        bookingEventDTO.setMessage("Booking is creating");
        bookingEventDTO.setStatus("pending");
        bookingProducer.sendMessage(bookingEventDTO);

        return  bookingService.addBooking(bookingDTO);
    }
    @GetMapping("/getbookings")
    public List<BookingDTO> getAllBookings(){
        return bookingService.getAll();
    }
    @GetMapping("/getbooking/{id}")
    public BookingDTO getBookingById(@PathVariable int id){
        return bookingService.getBYId(id);
    }
    @PutMapping("/updatebooking")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(bookingDTO);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id){
        return bookingService.deleteById(id);
    }

}
