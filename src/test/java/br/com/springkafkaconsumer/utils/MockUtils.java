package br.com.springkafkaconsumer.utils;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;
import br.com.springkafkaconsumer.adapter.dto.PeopleDTO;
import br.com.springkafkaproducer.CarAvro;
import br.com.springkafkaproducer.PeopleAvro;

import java.util.Collections;
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

    public static PeopleDTO getPeopleDTO() {
        return PeopleDTO
                .builder()
                .id(UUID.randomUUID().toString())
                .name("Vinicius")
                .cpf("00011122233")
                .books(Collections.singletonList("Book1"))
                .build();
    }

    public static PeopleAvro getPeopleAvro() {
        return PeopleAvro.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setName("Vinicius")
                .setCpf("00011122233")
                .setBooks(Collections.singletonList("Book1"))
                .build();
    }
}
