package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1800464589495496816L;
	private int nTrans = 0;
	private int nMaxAtm = 0;

	public TransactionsOverQuotaException(int trans, int atm) {
		this.nTrans = trans;
		this.nMaxAtm = atm;
	}

	public String toString() {
		return "TransactionsOverQuotaException [Number of transitions=" + nTrans
				+ ", are more than the limit of MaxATM Transitions=" + nMaxAtm + "]";
	}

	public String getMessage() {
		return this.toString();
	}

}
