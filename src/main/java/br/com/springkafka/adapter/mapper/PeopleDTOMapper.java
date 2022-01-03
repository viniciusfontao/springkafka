package br.com.springkafka.adapter.mapper;

import br.com.springkafka.PeopleAvro;
import br.com.springkafka.adapter.dto.PeopleDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PeopleDTOMapper {

    public PeopleDTO toDTO(PeopleAvro peopleAvro) {
        return PeopleDTO.builder()
                .id(peopleAvro.getId().toString())
                .cpf(peopleAvro.getCpf().toString())
                .name(peopleAvro.getName().toString())
                .books(peopleAvro.getBooks().stream().map(CharSequence::toString).collect(Collectors.toList()))
                .build();
    }

}
