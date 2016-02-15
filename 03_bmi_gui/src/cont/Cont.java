package cont;
import bll.Funk;
import bll.IFunk;
import dal.Data;
import dal.IData.DataException;
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
			try {
				io.skriv(funk.getNavn(cpr) + " " + funk.getTextualBMI(cpr));
			} catch (DataException e) {
				io.skriv("Bruger findes ikke!");
			}
			io.close();
	}
	
}
