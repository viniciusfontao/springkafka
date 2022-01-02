package br.com.springkafka.consumer;

import br.com.springkafka.PeopleAvro;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PeopleConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void consumer(ConsumerRecord<String, PeopleAvro> record, Acknowledgment ack) {
        var people = record.value();
        log.info(people.toString());

        ack.acknowledge();
    }
}
