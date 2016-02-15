package io;
import java.util.Scanner;

public class IoTxt implements IIo {
	
	private Scanner tastatur;
	
	public IoTxt(){
		tastatur = new Scanner(System.in);
	}

	public String laes(){
		return tastatur.nextLine().trim();
	}
	
	public void skriv(String tekst){
		System.out.println(tekst);
	}
	
	public void close(){
		tastatur.close();
	}

}
