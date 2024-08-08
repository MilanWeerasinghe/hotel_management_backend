package com.hotel.room.kafka;

import com.hotel.base.dto.BookingEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingEventDTO.class);

    @KafkaListener(
            topics = "${spring.kafka.template.default-topic}",
            groupId = "spring.kafka.consumer.group-id"
    )

    public void consume(BookingEventDTO bookingEventDTO){
        LOGGER.info(String.format("Receiving booking from the booking service %s", bookingEventDTO.toString()));
    }
}
