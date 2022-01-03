package br.com.springkafka.domain.usecase;

import br.com.springkafka.adapter.dto.PeopleDTO;
import br.com.springkafka.domain.mapper.PeopleEntityMapper;
import br.com.springkafka.domain.model.Book;
import br.com.springkafka.domain.usecase.port.PeoplePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PeopleConsumerUseCase {

    private final PeoplePort peoplePort;

    private final PeopleEntityMapper peopleEntityMapper;

    public void execute(PeopleDTO peopleDTO) {
        var people = peopleEntityMapper.toEntity(peopleDTO);
        people.setBooks(peopleDTO.getBooks().stream()
                .map(bookName -> Book.builder()
                        .name(bookName)
                        .build())
                .collect(Collectors.toList()));

        peoplePort.save(people);
    }
}
