package br.com.springkafkaconsumer.domain.usecase;

import br.com.springkafkaconsumer.domain.usecase.port.PeoplePort;
import br.com.springkafkaconsumer.utils.MockUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PeopleConsumerUseCaseTest {

    @InjectMocks
    private PeopleConsumerUseCase peopleConsumerUseCase;

    @Mock
    private PeoplePort peoplePort;

    @Test
    void givenAPeopleDTOThenCallPeopleConsumerPort() {

        var peopleDTO = MockUtils.getPeopleDTO();

        peopleConsumerUseCase.execute(peopleDTO);

        Mockito.verify(peoplePort).save(peopleDTO);
        Mockito.verifyNoMoreInteractions(peoplePort);
    }

}
