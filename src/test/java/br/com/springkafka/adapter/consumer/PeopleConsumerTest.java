package br.com.springkafka.adapter.consumer;

import br.com.springkafka.adapter.mapper.PeopleDTOMapper;
import br.com.springkafka.domain.usecase.PeopleConsumerUseCase;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.support.Acknowledgment;

import static br.com.springkafka.utils.MockUtils.getPeopleAvro;
import static br.com.springkafka.utils.MockUtils.getPeopleDTO;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PeopleConsumerTest {

    @InjectMocks
    private PeopleConsumer peopleConsumer;

    @Mock
    private PeopleConsumerUseCase peopleConsumerUseCase;

    @Mock
    private PeopleDTOMapper peopleDTOMapper;

    @Mock
    private Acknowledgment ack;

    @Test
    void givenAPeopleAvroMessageWhenConsumesThenCallUseCase() {
        var peopleAvroMessage = getPeopleAvro();
        var peopleDTO = getPeopleDTO();

        when(peopleDTOMapper.toDTO(peopleAvroMessage)).thenReturn(peopleDTO);
        doNothing().when(peopleConsumerUseCase).execute(peopleDTO);
        doNothing().when(ack).acknowledge();

        peopleConsumer.consumer(new ConsumerRecord<>("Peoples", 0, 0, "message-key", peopleAvroMessage), ack);
        verify(peopleConsumerUseCase).execute(peopleDTO);
        verify(ack).acknowledge();
        verifyNoMoreInteractions(peopleConsumerUseCase);
        verifyNoMoreInteractions(peopleDTOMapper);
        verifyNoMoreInteractions(ack);
    }
}
