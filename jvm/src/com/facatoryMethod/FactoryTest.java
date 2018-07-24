package com.facatoryMethod;

public class FactoryTest {

	public static void main(String[] arge){
		SenderFactory sendFactory = new SenderFactory();
		Sender sender = sendFactory.produce("sms");
		sender.send();
	}
}
