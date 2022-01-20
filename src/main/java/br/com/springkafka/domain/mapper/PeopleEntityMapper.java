package br.com.springkafka.domain.mapper;

import br.com.springkafka.adapter.dto.PeopleDTO;
import br.com.springkafka.domain.model.Book;
import br.com.springkafka.domain.model.People;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PeopleEntityMapper {

    public People toEntity(PeopleDTO peopleDTO) {
        return People.builder()
                .id(peopleDTO.getId())
                .cpf(peopleDTO.getCpf())
                .name(peopleDTO.getName())
                .books(peopleDTO.getBooks()
                        .stream()
                        .map(this::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    private Book toEntity(String bookName) {
        return Book.builder()
                .name(bookName)
                .build();
    }
}
