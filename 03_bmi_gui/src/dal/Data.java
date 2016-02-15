package dal;
import java.util.ArrayList;
import java.util.Iterator;
import dal.IData.DataException;

public class Data implements IData {

	private ArrayList<Person> personer; 

	public Data(){
		personer = new ArrayList<Person>();
		// Tilføj personer
		personer.add(new Person("234567-8901", "Ib Olsen", 1.80, 75.0));
		personer.add(new Person("456789-0123", "Ole Jensen", 1.75, 95.0));
		personer.add(new Person("123456-7890", "Eva Hansen", 1.65, 65.0));
		// print dem lige ud til debug
		Iterator<Person> it =  personer.iterator();
		while(it.hasNext()) 
			System.out.println(it.next());
		System.out.println("---");
	}

	//Returner personens navn
	public String getNavn(String cpr) throws DataException{
		for (int i= 0; ; i++){
			try {
				if (personer.get(i).cpr.equals(cpr))
					return personer.get(i).navn;
			} catch (IndexOutOfBoundsException e){
				System.err.println("Personen findes ikke");
				throw new DataException();
			}
		}
	}

	//Returner personens vægt
	public double getVaegt(String cpr) throws DataException{
		for (int i= 0; ; i++)
			try {
				if (personer.get(i).cpr.equals(cpr))
					return personer.get(i).vaegt;
			} catch (IndexOutOfBoundsException e){
				throw new DataException();
			}
	}

	//Returner personens højde
	public double getHoejde(String cpr) throws DataException{
		for (int i= 0; ; i++)
			try {
				if (personer.get(i).cpr.equals(cpr))
					return personer.get(i).hoejde;
			} catch (IndexOutOfBoundsException e){
				throw new DataException();
			}
	}

	private class Person {
		String cpr;
		String navn;
		double hoejde;
		double vaegt;

		private Person(String cpr, String navn, double hoejde, double vaegt) {
			super();
			this.cpr = cpr;
			this.navn = navn;
			this.hoejde = hoejde;
			this.vaegt = vaegt;
		}

		public String toString(){
			return cpr + " " + navn;
		}
	}
}
