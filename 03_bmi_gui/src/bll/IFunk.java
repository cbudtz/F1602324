package bll;

public interface IFunk {
	public double getBMI(String cpr); 			// beregn BMI udfra personens CPR-nr
	public String getTextualBMI(String cpr); 	// returnér en tekst der beskriver BMI intervallet 
	public String getNavn(String cpr); 			// returnér perosn navn udfra CPR-nr
}
