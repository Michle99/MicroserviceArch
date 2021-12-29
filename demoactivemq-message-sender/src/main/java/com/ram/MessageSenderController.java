package com.ram;

import com.ram.model.Product;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

@RestController
public class MessageSenderController {
    @Autowired
    JmsTemplate jmsTemplate;

    @PostMapping("/sendmessage")
    private void sendMessage(@RequestBody String message){
            // Product product = new Product();
			// product.setProductId(10);
			// product.setName("Laptop");
			// product.setQuantity( 10);

            jmsTemplate.convertAndSend("orders", message);
    }
}
