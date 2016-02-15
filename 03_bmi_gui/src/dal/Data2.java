package dal;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


import dal.IData;
									 
public class Data2 implements Serializable, IData {
	private static final long serialVersionUID = -372123270345792185L;

	private class Person implements Serializable{
		private static final long serialVersionUID = 150643518387140262L;
		String cpr;
		String navn;
		double hoejde;
		double vaegt;

		public Person(String cpr, String navn, double hoejde, double vaegt) {
			super();
			this.cpr = cpr;
			this.navn = navn;
			this.hoejde = hoejde;
			this.vaegt = vaegt;
		}

		public String toString(){
			return cpr + navn;
		}
	}
	
	private ArrayList<Person> personer; 

	public Data2(){
		personer = new ArrayList<Person>();
		
		File f = new File("data.dat");
		if (!f.exists()){	
			personer.add(new Person("234567-8901", "Ib Olsen", 1.80, 75.0));
			personer.add(new Person("456789-0123", "Ole Jensen", 1.75, 95.0));
			personer.add(new Person("123456-7890", "Eva Hansen", 1.65, 65.0));
			writeToDisk();
		}	
		
		readFromDisk();
	}
	
	//Returner personens navn
	public String getNavn(String cpr){
		for (int i= 0; i< personer.size(); i++)
			if (personer.get(i).cpr.equals(cpr))
				return personer.get(i).navn;
		return null;
	}
	//Returner personens vægt
	public double getVaegt(String cpr){
		for (int i= 0; i< personer.size(); i++)
			if (personer.get(i).cpr.equals(cpr))
				return personer.get(i).vaegt;
		return -1;
	}
	//Returner personens højde
	public double getHoejde(String cpr){
		for (int i= 0; i< personer.size(); i++)
			if (personer.get(i).cpr.equals(cpr))
				return personer.get(i).hoejde;
		return -1;
	}
	
	private void writeToDisk(){
		ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new
                    BufferedOutputStream(new 				         
                    		FileOutputStream("data.dat")));
            
            out.writeObject(personer);
//            Iterator<Person> it =  personer.iterator();
//            while(it.hasNext())
//            	out.writeObject(it.next());
        }    
        catch (IOException e) {
        	e.printStackTrace();
        	e.getMessage();
        }
        finally {
            try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}


	@SuppressWarnings("unchecked")
	private void readFromDisk(){
		ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new
                    BufferedInputStream(new FileInputStream("data.dat")));
            
            //personer =  (ArrayList) in.readObject();

            personer = (ArrayList<Person>) in.readObject();

            // print dem lige ud
            Iterator<Person> it =  personer.iterator();
            while(it.hasNext()) 
            System.out.println(it.next());
            
        }
        catch (EOFException e) {
        	e.printStackTrace();
        } 	
        catch (IOException e) {
        	e.printStackTrace();
        } 
        catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
        
        
        finally {
        	try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}




