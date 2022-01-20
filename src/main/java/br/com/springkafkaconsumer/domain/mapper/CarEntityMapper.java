package br.com.springkafkaconsumer.domain.mapper;

import br.com.springkafkaconsumer.adapter.dto.CarDTO;
import br.com.springkafkaconsumer.domain.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CarEntityMapper {

    public Car toEntity(CarDTO carDTO) {
        return Car.builder()
                .id(carDTO.getId())
                .name(carDTO.getName())
                .brand(carDTO.getBrand())
                .build();
    }
}
