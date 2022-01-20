package br.com.springkafka.adapter.gateway;

import br.com.springkafka.adapter.repository.PeopleRepository;
import br.com.springkafka.domain.mapper.PeopleEntityMapper;
import br.com.springkafka.domain.model.Book;
import br.com.springkafka.domain.model.People;
import br.com.springkafka.utils.MockUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

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
