package net.wessendorf.knative;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class KafkaEventConsumer{

    private static final Logger LOG = LoggerFactory.getLogger(KafkaEventConsumer.class);

    @Incoming("meters")
    public CompletionStage<Void> onMessage(KafkaMessage<String, String> message) throws IOException {

        LOG.info("Kafka message with value = {} arrived", message.getPayload());
        return message.ack();
    }

}
