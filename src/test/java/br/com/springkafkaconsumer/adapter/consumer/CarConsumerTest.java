package br.com.springkafkaconsumer.adapter.consumer;

import br.com.springkafkaconsumer.adapter.mapper.CarDTOMapper;
import br.com.springkafkaconsumer.domain.usecase.CarConsumerUseCase;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.support.Acknowledgment;

import static br.com.springkafkaconsumer.utils.MockUtils.getCarAvro;
import static br.com.springkafkaconsumer.utils.MockUtils.getCarDTO;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarConsumerTest {

    @InjectMocks
    private CarConsumer carConsumer;

    @Mock
    private CarConsumerUseCase carConsumerUseCase;

    @Mock
    private CarDTOMapper carDTOMapper;

    @Mock
    private Acknowledgment ack;

    @Test
    void givenACarAvroMessageWhenConsumesThenCallUseCase() {
        var carAvroMessage = getCarAvro();
        var carDTO = getCarDTO();

        when(carDTOMapper.toDTO(carAvroMessage)).thenReturn(carDTO);
        doNothing().when(carConsumerUseCase).execute(carDTO);
        doNothing().when(ack).acknowledge();

        carConsumer.consumer(new ConsumerRecord<>("cars", 0, 0, "message-key", carAvroMessage), ack);
        verify(carConsumerUseCase).execute(carDTO);
        verify(ack).acknowledge();
        verifyNoMoreInteractions(carConsumerUseCase);
        verifyNoMoreInteractions(carDTOMapper);
        verifyNoMoreInteractions(ack);
    }
}
