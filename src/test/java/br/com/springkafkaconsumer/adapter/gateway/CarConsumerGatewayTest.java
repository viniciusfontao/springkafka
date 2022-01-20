package br.com.springkafkaconsumer.adapter.gateway;

import br.com.springkafkaconsumer.adapter.repository.CarRepository;
import br.com.springkafkaconsumer.domain.mapper.CarEntityMapper;
import br.com.springkafkaconsumer.domain.model.Car;
import br.com.springkafkaconsumer.utils.MockUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarConsumerGatewayTest {

    @InjectMocks
    private CarGateway carGateway;

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarEntityMapper carEntityMapper;

    @DisplayName("Given a CarDTO, map to Entity and calls repository to save")
    @Test
    void givenACarDTOThenMapAndSave() {
        var carDTO = MockUtils.getCarDTO();

        var carEntity = Car.builder()
                .id(carDTO.getId())
                .name("207")
                .brand("Peugeot")
                .build();

        when(carEntityMapper.toEntity(carDTO)).thenReturn(carEntity);
        when(carRepository.save(carEntity)).thenReturn(carEntity);

        carGateway.save(carDTO);
        verifyNoMoreInteractions(carEntityMapper);
        verifyNoMoreInteractions(carRepository);
    }
}
