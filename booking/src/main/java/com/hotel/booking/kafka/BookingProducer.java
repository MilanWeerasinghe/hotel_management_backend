package com.hotel.booking.kafka;

import com.hotel.base.dto.BookingEventDTO;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class BookingProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingEventDTO.class);

    private final NewTopic bookingTopic;

    private final KafkaTemplate<String, BookingEventDTO> kafkaTemplate;

    public BookingProducer(NewTopic bookingTopic, KafkaTemplate<String, BookingEventDTO> kafkaTemplate) {
        this.bookingTopic = bookingTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(BookingEventDTO bookingEventDTO){
        LOGGER.info(String.format("sending booking to the room service %s", bookingEventDTO.toString()));

        Message<BookingEventDTO> message = MessageBuilder
                .withPayload(bookingEventDTO)
                .setHeader(KafkaHeaders.TOPIC, bookingTopic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
