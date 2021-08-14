package com.emilionicoli.exp.helloworld;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.emilionicoli.exp.helloworld.service.HelloService;
import com.emilionicoli.exp.helloworld.view.Request;
import com.emilionicoli.exp.helloworld.view.Response;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class HelloLambdaHandlerTest {

    @Test
    public void testLoadEventBridgeEvent() throws IOException {
        // Given
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream eventStream = this.getClass().getResourceAsStream("event.json");
        ScheduledEvent event = objectMapper.readValue(eventStream, ScheduledEvent.class);
        EventHandler<ScheduledEvent, String> handler = new EventHandler<>();

        // When
        String response = handler.handleRequest(event, contextMock);

        // Then
        assertThat(response).isEqualTo("something");
    }
}