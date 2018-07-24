package com.facatoryMethod;

public class StaticMultipleSenderFactoryTest {

	public static void main(String[] args) {
		Sender mailSender = StaticMultipleSenderFactory.produceMail();
		mailSender.send();
	}

}
