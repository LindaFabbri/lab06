package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U> Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

	final Map<String, List<U>> contatto; // contatto ha la stringa per il nome del gruppo e List per la lista delle
											// persone (user) che appartengono a quel gruppo

	/*
	 * 
	 * [FIELDS]
	 * 
	 * Define any necessary field
	 * 
	 * In order to save the people followed by a user organized in groups, adopt a
	 * generic-type Map:
	 * 
	 * think of what type of keys and values would best suit the requirements
	 */

	/*
	 * [CONSTRUCTORS]
	 * 
	 * 1) Complete the definition of the constructor below, for building a user
	 * participating in a social network, with 4 parameters, initializing:
	 * 
	 * - firstName - lastName - username - age and every other necessary field
	 * 
	 * 2) Define a further constructor where age is defaulted to -1
	 */

	/**
	 * Builds a new {@link SocialNetworkUserImpl}.
	 * 
	 * @param name    the user firstname
	 * @param surname the user lastname
	 * @param userAge user's age
	 * @param user    alias of the user, i.e. the way a user is identified on an
	 *                application
	 */
	public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
		super(name, surname, user, userAge);
		contatto = new HashMap<>();
	}

	public SocialNetworkUserImpl(final String name, final String surname, final String user) {
		super(name, surname, user);
		contatto = new HashMap<>();
	}

	/*
	 * [METHODS]
	 * 
	 * Implements the methods below
	 */

	@Override
	public boolean addFollowedUser(final String circle, final U user) {

		boolean res = false;

		for (List<U> amiciList : contatto.values()) {
			if (amiciList.contains(user)) {
				res = false;
			} else {
				res = true;
			}
		}
		if (contatto.containsKey(circle)) {
			contatto.get(circle).add(user);
		} else {
			final List<U> gruppoTemp = new ArrayList<>();
			gruppoTemp.add(user);
			contatto.put(circle, gruppoTemp);
		}
		return res;
	}

	@Override
	public Collection<U> getFollowedUsersInGroup(final String groupName) {
		if (contatto.containsKey(groupName)) {
			return new ArrayList<>(contatto.get(groupName));
		} else {
			return new ArrayList<>();
		}

	}

	@Override
	public List<U> getFollowedUsers() {
		List<U> tuttiAmiciList = new ArrayList<>();
		for (List<U> utenteList : contatto.values()) {
			for (U utenteU : utenteList) {
				if (!tuttiAmiciList.contains(utenteU)) {
					tuttiAmiciList.add(utenteU);
				}
			}
		}
		return tuttiAmiciList;
	}
}
