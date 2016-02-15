package dal;

public interface IData {
	public String getNavn(String cpr) throws DataException;
	public double getHoejde(String cpr) throws DataException;
	public double getVaegt(String cpr) throws DataException; 
	
	public class DataException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}

}
