package br.com.springkafkaconsumer.adapter.mapper;

import br.com.springkafkaproducer.PeopleAvro;
import br.com.springkafkaconsumer.adapter.dto.PeopleDTO;
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
