package com.facatoryMethod;

public class AbstractFactoryTest {

	public static void main(String[] args) {

		Provider provider = new SmsSenderFactory();
		Sender sender = provider.produce();
		sender.send();
	}

}
