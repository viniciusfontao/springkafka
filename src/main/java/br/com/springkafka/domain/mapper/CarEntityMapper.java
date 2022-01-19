package br.com.springkafka.domain.mapper;

import br.com.springkafka.adapter.dto.CarDTO;
import br.com.springkafka.domain.model.Car;
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
