package br.com.springkafkaconsumer.adapter.gateway;

import br.com.springkafkaconsumer.adapter.repository.PeopleRepository;
import br.com.springkafkaconsumer.domain.mapper.PeopleEntityMapper;
import br.com.springkafkaconsumer.domain.model.Book;
import br.com.springkafkaconsumer.domain.model.People;
import br.com.springkafkaconsumer.utils.MockUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleGatewayTest {

    @InjectMocks
    private PeopleGateway peopleGateway;

    @Mock
    private PeopleRepository peopleRepository;

    @Mock
    private PeopleEntityMapper peopleEntityMapper;

    @DisplayName("Given a PeopleDTO, map to Entity and calls repository to save")
    @Test
    void givenAPeopleDTOThenMapAndSave() {
        var peopleDTO = MockUtils.getPeopleDTO();

        var peopleEntity = People.builder()
                .id(peopleDTO.getId())
                .name("Vinicius")
                .cpf("00011122233")
                .books(Collections.singletonList(Book.builder()
                        .name("Book1")
                        .build()))
                .build();

        when(peopleEntityMapper.toEntity(peopleDTO)).thenReturn(peopleEntity);
        when(peopleRepository.save(peopleEntity)).thenReturn(peopleEntity);

        peopleGateway.save(peopleDTO);
        verifyNoMoreInteractions(peopleEntityMapper);
        verifyNoMoreInteractions(peopleRepository);
    }
}
