package br.com.springkafka.adapter.mapper;

import org.junit.jupiter.api.Test;

import static br.com.springkafka.utils.MockUtils.getCarAvro;
import static org.assertj.core.api.Assertions.assertThat;

public class CarDTOMapperTest {

    private final CarDTOMapper carDTOMapper = new CarDTOMapper();

    @Test
    void givenACarAvroThenReturnCarDTO() {
        var carAvro = getCarAvro();

        var carDTO = carDTOMapper.toDTO(carAvro);

        assertThat(carDTO.getId()).isEqualTo(carAvro.getId());
        assertThat(carDTO.getName()).isEqualTo(carAvro.getName());
        assertThat(carDTO.getBrand()).isEqualTo(carAvro.getBrand());
    }
}
