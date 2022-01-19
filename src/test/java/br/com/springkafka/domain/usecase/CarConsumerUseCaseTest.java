package br.com.springkafka.domain.usecase;

import br.com.springkafka.domain.usecase.port.CarPort;
import br.com.springkafka.utils.MockUtils;
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
