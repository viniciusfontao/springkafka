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
        assertThat(carDTO.getId()).isEqualTo(carEntity.getId());
        assertThat(carDTO.getName()).isEqualTo(carEntity.getName());
        assertThat(carDTO.getBrand()).isEqualTo(carEntity.getBrand());
    }
}
