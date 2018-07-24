package com.facatoryMethod;

public class MultipleSenderFactoryTest {

	public static void main(String[] args) {
		MultipleSenderFactory msf = new MultipleSenderFactory();
		Sender mailSender = msf.produceMail();
		mailSender.send();
	}

}
