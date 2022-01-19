package br.com.springkafka.utils;

import br.com.springkafka.adapter.dto.CarDTO;
import br.com.springkafkaproducer.CarAvro;

import java.util.UUID;

public class MockUtils {

    public static CarDTO getCarDTO() {
        return CarDTO
                .builder()
                .id(UUID.randomUUID().toString())
                .name("207")
                .brand("Peugeot")
                .build();
    }

    public static CarAvro getCarAvro() {
        return CarAvro.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setName("207")
                .setBrand("Peugeot")
                .build();
    }
}
