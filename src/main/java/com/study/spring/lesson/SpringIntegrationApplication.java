package com.study.spring.lesson;

import com.study.spring.lesson.domain.Product;
import com.study.spring.lesson.integration.ChannelGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

import java.util.Collections;

@SpringBootApplication
@IntegrationComponentScan
public class SpringIntegrationApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication app = new SpringApplication(SpringIntegrationApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8090"));
        ConfigurableApplicationContext context = app.run(args);

//        ChannelGateway channelGateway = context.getBean(ChannelGateway.class);
//        channelGateway.process(new Product("Milk", 34.34));
//        channelGateway.process(new Product("Chocolate", 114.34));
////
        DirectChannel invokeCallGetProducts = context.getBean("invokeCallGetProducts", DirectChannel.class);
        invokeCallGetProducts.send(MessageBuilder.withPayload("").build());

        PollableChannel productsChannel = context.getBean("get_products_channel", PollableChannel.class);
        Message<?> receive = productsChannel.receive();
        if (receive != null) {
            System.out.println(receive);
            System.out.println(receive.getPayload());
        }
    }

}
