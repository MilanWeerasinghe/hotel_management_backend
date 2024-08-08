package com.hotel.booking.service;

import com.hotel.booking.common.BookingResponse;
import com.hotel.booking.common.Error;
import com.hotel.booking.common.Success;
import com.hotel.booking.dto.BookingDTO;
import com.hotel.booking.keycloak.KeycloakService;
import com.hotel.booking.model.Booking;
import com.hotel.booking.repo.BookingRepo;
import com.hotel.room.dto.RoomDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {
    private WebClient roomWebClient; ;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final KeycloakService keycloakService;



    public BookingService(WebClient roomWebClient, BookingRepo bookingRepo, ModelMapper modelMapper, KeycloakService keycloakService) {
        this.roomWebClient = roomWebClient;
        this.bookingRepo = bookingRepo;
        this.modelMapper = modelMapper;
        this.keycloakService = keycloakService;
    }

    public BookingResponse addBooking(BookingDTO bookingDTO){
        Integer bookingId = bookingDTO.getRoomId();
        String token = keycloakService.getAccessToken();

        try{
            RoomDTO response = roomWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/room/getroom/{id}").build(bookingId))
                    .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .bodyToMono(RoomDTO.class)
                    .block();

            assert response != null;
            if(response.getStatus().equals("available")){
                bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
                return new Success(bookingDTO);
            }
            else{
                return new Error("Room is not available");
            }
        }catch (WebClientResponseException e){
            if (e.getStatusCode().is5xxServerError()){
                return new Error("room not found");
            }
        }
        catch (NullPointerException e){
            return new Error("null");
        }
        return null;

    }

    public List<BookingDTO> getAll(){
        List<Booking> bookingList = bookingRepo.findAll();
        return modelMapper.map(bookingList, new TypeToken<List<BookingDTO>>(){}.getType());
    }
    public BookingDTO updateBooking(BookingDTO bookingDTO){
        bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        return bookingDTO;
    }
    public BookingDTO getBYId(int id){
        Optional<Booking> booking = bookingRepo.findById(id);
        return modelMapper.map(booking, new TypeToken<BookingDTO>(){}.getType());
    }
    public String deleteById(int id){
        bookingRepo.deleteById(id);
        return "successfully deleted booking: "+id;
    }
}
