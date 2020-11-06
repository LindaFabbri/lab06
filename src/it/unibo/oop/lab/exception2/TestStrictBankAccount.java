package it.unibo.oop.lab.exception2;

import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	
    	StrictBankAccount s1 = new StrictBankAccount(123, 10000, 10);
    	StrictBankAccount s2 = new StrictBankAccount(456, 10000, 10);
    	
    	try {
    		s1.deposit(123, 10); //senza eccezione
    		s2.deposit(123, 1); //eccezione WrongAccount
    		
    		s1.withdraw(123, 10); //senza eccezione
    		s2.withdraw(456, 50000); // eccezione NotEnoughFounds
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());  		
    	}
    	
    	try {
    		s1.deposit(123, 10); //senza eccezione
    		s2.deposit(123, 1); //eccezione WrongAccount
    		
    		s1.withdraw(123, 10); //senza eccezione
    		s2.withdraw(456, 50000); // eccezione NotEnoughFounds
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());  		
    	}
    	
    }
}
