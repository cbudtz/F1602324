package bll;

import dal.IData.DataException;

public interface IFunk {
	public double getBMI(String cpr) throws DataException; 			// beregn BMI udfra personens CPR-nr
	public String getTextualBMI(String cpr) throws DataException; 	// return�r en tekst der beskriver BMI intervallet 
	public String getNavn(String cpr) throws DataException; 			// return�r perosn navn udfra CPR-nr
}
