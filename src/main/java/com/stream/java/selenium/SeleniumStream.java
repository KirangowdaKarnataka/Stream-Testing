package com.stream.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		// Maximize the window(browser)(before hitting the url first it will maxmize the browser)
		driver.manage().window().maximize();
		driver.get("");
	}

}
