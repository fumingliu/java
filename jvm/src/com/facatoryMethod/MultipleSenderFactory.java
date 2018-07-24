package com.facatoryMethod;

public class MultipleSenderFactory {

	public Sender produceMail(){
		return new MailSender();
	}
	public Sender produceSms(){
		return new SmsSender();
	}
}
