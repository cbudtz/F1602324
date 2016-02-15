package io;

import desktop_resources.GUI;

public class IoGui implements IIo {
	
	public IoGui(){
	}

	public String laes(){
		return GUI.getUserString("");
	}
	
	public void skriv(String tekst){
		GUI.showMessage(tekst);
	}
	
	public void close(){
		GUI.close();
	}

}
