package com.ram.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ram.model.Product;

@Component
public class MessageReceiver
{
	private static final String MESSAGE_QUEUE = "orders";
	
	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(Product product)
	{
		System.out.println("Received " + product);
//		if(product.getQuantity()%2 ==0) {
//			throw new RuntimeException();
//		}
	}
}