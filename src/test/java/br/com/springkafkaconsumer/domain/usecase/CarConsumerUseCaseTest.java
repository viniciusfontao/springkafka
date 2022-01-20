package br.com.springkafkaconsumer.domain.usecase;

import br.com.springkafkaconsumer.domain.usecase.port.CarPort;
import br.com.springkafkaconsumer.utils.MockUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CarConsumerUseCaseTest {

    @InjectMocks
    private CarConsumerUseCase carConsumerUseCase;

    @Mock
    private CarPort carPort;

    @Test
    void givenACarDTOThenCallCarConsumerPort() {

        var carDTO = MockUtils.getCarDTO();

        carConsumerUseCase.execute(carDTO);

        Mockito.verify(carPort).save(carDTO);
        Mockito.verifyNoMoreInteractions(carPort);
    }
}
