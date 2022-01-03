package br.com.springkafka.adapter.producer;

import br.com.springkafka.PeopleAvro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PeopleProducer {

    private final String topicName;
    private final KafkaTemplate<String, PeopleAvro> kafkaTemplate;

    public PeopleProducer(@Value("${topic.name}") String topicName, KafkaTemplate<String, PeopleAvro> kafkaTemplate
    ) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(PeopleAvro peopleAvro) {
        kafkaTemplate.send(topicName, peopleAvro).addCallback(
                success -> log.info("Message sent successfully!"),
                failure -> log.error("Error while sending the message!")
        );
    }
}
