package br.com.springkafka.adapter.controller;

import br.com.springkafka.PeopleAvro;
import br.com.springkafka.adapter.dto.PeopleRequestDTO;
import br.com.springkafka.adapter.producer.PeopleProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/peoples")
@AllArgsConstructor
public class PeopleController {

    private final PeopleProducer peopleProducer;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody PeopleRequestDTO peopleDTO) {
        var id = UUID.randomUUID().toString();

        var message = PeopleAvro.newBuilder()
                .setId(id)
                .setName(peopleDTO.getName())
                .setCpf(peopleDTO.getCpf())
                .setBooks(peopleDTO.getBooks().stream().map(p -> (CharSequence) p).collect(Collectors.toList()))
                .build();

        peopleProducer.sendMessage(message);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
