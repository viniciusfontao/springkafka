package br.com.springkafka.adapter.controller;

import br.com.springkafka.adapter.dto.PeopleRequestDTO;
import br.com.springkafka.adapter.mapper.PeopleProducerDTOMapper;
import br.com.springkafka.domain.usecase.PeopleProducerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peoples")
@AllArgsConstructor
public class PeopleController {

    private final PeopleProducerUseCase peopleProducerUseCase;

    private final PeopleProducerDTOMapper peopleProducerDTOMapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> sendMessage(@RequestBody PeopleRequestDTO peopleRequestDTO) {

        peopleProducerUseCase.execute(peopleProducerDTOMapper.toDTO(peopleRequestDTO));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
