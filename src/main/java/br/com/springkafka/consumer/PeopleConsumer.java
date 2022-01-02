package br.com.springkafka.consumer;

import br.com.springkafka.PeopleAvro;
import br.com.springkafka.domain.Book;
import br.com.springkafka.domain.People;
import br.com.springkafka.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class PeopleConsumer {

    private final PeopleRepository peopleRepository;

    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, PeopleAvro> record, Acknowledgment ack) {
        var peopleAvro = record.value();

        log.info("Message received:" + peopleAvro.toString());

        var people = People.builder()
                .id(peopleAvro.getId().toString())
                .cpf(peopleAvro.getCpf().toString())
                .name(peopleAvro.getName().toString())
                .build();

        var books = peopleAvro.getBooks()
                .stream()
                .map(book -> Book.builder()
                        .people(people)
                        .name(book.toString())
                        .build())
                .collect(Collectors.toList());

        people.setBooks(books);

        peopleRepository.save(people);

        ack.acknowledge();
    }
}
