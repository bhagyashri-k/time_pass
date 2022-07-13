package com.pack;

import java.util.Random;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.javafaker.Faker;

public class Random_Demo {

	public static void main(String[] args) {
		
		Random r = new Random();
		
		Faker fake = new Faker();
		
		int number = r.nextInt(1000);
		
		String name = fake.name().firstName();
		
		String suffix = "gmail.com";
		
		String mailId=name+number+suffix;
		System.out.println(mailId);
		
		
		LoggingPreferences per  = new LoggingPreferences();
		RemoteWebDriver dr = new ChromeDriver();

	}

}
