package bll;

public interface IFunk {
	public double getBMI(String cpr); 			// beregn BMI udfra personens CPR-nr
	public String getTextualBMI(String cpr); 	// return�r en tekst der beskriver BMI intervallet 
	public String getNavn(String cpr); 			// return�r perosn navn udfra CPR-nr
}
