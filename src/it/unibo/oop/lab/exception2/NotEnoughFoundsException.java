package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException{
	
	
	private static final long serialVersionUID = -7722699687989822822L;
	private int usrID = 0;
	private double balance = 0;
	
	public NotEnoughFoundsException(int usrID, double balance) {
		this.usrID = usrID;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "NotEnoughFoundsException [usrID=" + usrID + ", there is not enough money for a draw operation, because the balance is " + balance + "]";
	}
	
	public String getMessage() {
		return this.toString();
	}

}
