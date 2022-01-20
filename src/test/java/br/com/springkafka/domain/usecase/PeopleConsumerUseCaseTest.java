package br.com.springkafka.domain.usecase;

import br.com.springkafka.domain.usecase.port.PeoplePort;
import br.com.springkafka.utils.MockUtils;
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
