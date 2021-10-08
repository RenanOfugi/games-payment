package com.games.ecommerce.gamespayment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.ecommerce.gamespayment.entity.CheckoutEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GamesPaymentService {

    @KafkaListener(topics = "SalvaCheckout", groupId = "GamesMicroservices")
    private void saveGamesCheckout(ConsumerRecord<String, String> record){
        log.info("chave = {}", record.key());
        log.info("cabeçalho = {}", record.headers());
        log.info("Valores = {}", record.value());

        String data = record.value();

        ObjectMapper mapper = new ObjectMapper();
        CheckoutEntity entity = null;

        try {
            entity = mapper.readValue(data, CheckoutEntity.class);
        } catch (JsonProcessingException e) {
            System.out.println("Não foi possível realizar a conversão");
        }


    }
}
