package br.com.springkafkaconsumer.adapter.consumer;

import br.com.springkafkaproducer.PeopleAvro;
import br.com.springkafkaconsumer.adapter.mapper.PeopleDTOMapper;
import br.com.springkafkaconsumer.domain.usecase.PeopleConsumerUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PeopleConsumer {

    private final PeopleConsumerUseCase peopleConsumerUseCase;

    private final PeopleDTOMapper peopleDTOMapper;

    @KafkaListener(topics = "${topic.people.name}")
    public void consumer(ConsumerRecord<String, PeopleAvro> record, Acknowledgment ack) {
        var peopleAvro = record.value();

        log.info("Message received:" + peopleAvro.toString());

        var peopleDTO = peopleDTOMapper.toDTO(peopleAvro);

        peopleConsumerUseCase.execute(peopleDTO);

        ack.acknowledge();
    }
}
