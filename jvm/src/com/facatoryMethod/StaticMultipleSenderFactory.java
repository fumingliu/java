package com.facatoryMethod;

public class StaticMultipleSenderFactory {

	public static Sender produceMail(){
		return new MailSender();
	}
	public static Sender produceSms(){
		return new SmsSender();
	}
}
