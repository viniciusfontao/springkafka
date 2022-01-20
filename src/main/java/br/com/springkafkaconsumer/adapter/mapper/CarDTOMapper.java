package br.com.springkafkaconsumer.adapter.mapper;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;
import br.com.springkafkaproducer.CarAvro;
import org.springframework.stereotype.Component;

@Component
public class CarDTOMapper {

    public CarDTO toDTO(CarAvro carAvro) {
        return CarDTO.builder()
                .id(carAvro.getId().toString())
                .name(carAvro.getName().toString())
                .brand(carAvro.getBrand().toString())
                .build();
    }

}
