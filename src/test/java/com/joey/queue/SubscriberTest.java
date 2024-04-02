package com.joey.queue;

import com.joey.queue.subscriber.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.support.converter.MessageConverter;

import static org.mockito.Mockito.*;

class SubscriberTest {

    @Mock
    private MessageConverter messageConverter;

    @InjectMocks
    private Subscriber subscriber;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void consumerTest() {
        String message = "Test Message";
        Message mockMessage = mock(Message.class);
        when(messageConverter.fromMessage(mockMessage)).thenReturn(message);

        subscriber.consumer(mockMessage.toString());
    }
}
