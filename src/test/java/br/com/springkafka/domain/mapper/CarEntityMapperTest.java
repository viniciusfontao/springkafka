package br.com.springkafka.domain.mapper;

import br.com.springkafka.utils.MockUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarEntityMapperTest {

    private final CarEntityMapper carEntityMapper = new CarEntityMapper();

    @Test
    void givenACarDTOThenReturnCarEntity() {
        var carDTO = MockUtils.getCarDTO();

        var carEntity = carEntityMapper.toEntity(carDTO);
        assertThat(carEntity.getId()).isEqualTo(carDTO.getId());
        assertThat(carEntity.getName()).isEqualTo(carDTO.getName());
        assertThat(carEntity.getBrand()).isEqualTo(carDTO.getBrand());
    }
}
