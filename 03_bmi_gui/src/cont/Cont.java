package cont;
import bll.Funk;
import bll.IFunk;
import dal.Data;
import io.IIo;
import io.IoGui;
import io.IoTxt;

public class Cont {

	IFunk funk;
	IIo io;
	boolean gui;
	
	public Cont() {
		funk= new Funk(new Data());
		gui = true;
		if (gui)
			io= new IoGui();
		else
			io= new IoTxt();
	}

	public void run(){
		String cpr = "";
			io.skriv("Indtast cpr-nr: ");
			cpr=io.laes();    
			io.skriv(funk.getNavn(cpr) + " " + funk.getTextualBMI(cpr));
			io.close();
	}
	
}
