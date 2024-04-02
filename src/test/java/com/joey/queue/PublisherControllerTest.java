package com.joey.queue;

import com.joey.queue.service.RabbitMQService;
import com.joey.queue.publisher.PublisherController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

class PublisherControllerTest {

	@Mock
	private RabbitMQService rabbitMQService;

	@InjectMocks
	private PublisherController publisherController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void sendMessageTest() {
		String message = "Test Message";
		publisherController.sendMessage(message);
		verify(rabbitMQService, times(1)).sendMessage(message);
	}
}