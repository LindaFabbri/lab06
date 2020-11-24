package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6167772689578440371L;
	private int usrIDR = 0;
	private int usrIDP = 0;

	public WrongAccountHolderException(int usrIDRichiedente, int usrIDProprietario) {
		this.usrIDR = usrIDRichiedente;
		this.usrIDP = usrIDProprietario;
	}

	public String toString() {
		return "WrongAccountHolderException [user ID Richiedente=" + usrIDR + ", user ID Proprietario=" + usrIDP + "]";
	}

	public String getMessage() {
		return this.toString();
	}

}
