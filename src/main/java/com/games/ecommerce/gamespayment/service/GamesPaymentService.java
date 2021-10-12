package com.games.ecommerce.gamespayment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.ecommerce.gamespayment.entity.CheckoutPaymentEntity;
import com.games.ecommerce.gamespayment.repository.CheckoutGamesPaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GamesPaymentService {

    @Autowired
    private final CheckoutGamesPaymentRepository repository;

    @KafkaListener(topics = "SalvaCheckout", groupId = "GamesMicroservices")
    private void saveGamesCheckout(ConsumerRecord<String, String> record){
        log.info("chave = {}", record.key());
        log.info("cabeçalho = {}", record.headers());
        log.info("Partição = {}", record.partition());
        log.info("Valores = {}", record.value());

        String data = record.value();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CheckoutPaymentEntity entity;

        try {
            entity = mapper.readValue(data, CheckoutPaymentEntity.class);
	        System.out.println("Code: " + entity.getCode() + " - Recebido os dados de checkout com sucesso!");
            repository.save(entity);
        } catch (JsonProcessingException e) {
            System.out.println("-------------------------------------");
            System.out.println("Não foi possível realizar a conversão");
            e.printStackTrace();
            System.out.println("-------------------------------------");
        }
    }
}
