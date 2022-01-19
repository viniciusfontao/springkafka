package br.com.springkafka.adapter.mapper;

import br.com.springkafkaproducer.CarAvro;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static br.com.springkafka.utils.MockUtils.getCarAvro;
import static org.assertj.core.api.Assertions.assertThat;

public class CarDTOMapperTest {

    private final CarDTOMapper carDTOMapper = new CarDTOMapper();

    @Test
    void givenACarAvroThenReturnCarDTO() {
        var carAvro = getCarAvro();

        var carDTO = carDTOMapper.toDTO(carAvro);

        assertThat(carAvro.getId().toString()).isEqualTo(carDTO.getId());
        assertThat(carAvro.getName().toString()).isEqualTo(carDTO.getName());
        assertThat(carAvro.getBrand().toString()).isEqualTo(carDTO.getBrand());
    }
}
