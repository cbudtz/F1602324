package bll;

import dal.IData.DataException;

public interface IFunk {
	public double getBMI(String cpr) throws DataException; 			// beregn BMI udfra personens CPR-nr
	public String getTextualBMI(String cpr) throws DataException; 	// returnér en tekst der beskriver BMI intervallet 
	public String getNavn(String cpr) throws DataException; 			// returnér perosn navn udfra CPR-nr
}
