package VotingSystems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Santiago Andrade
 * 
  */

public class Ballot {
	/**
	 * Contiene lo que ser� la boleta real. Cada cadena ser� el nombre de cada
	 *	candidato y el �ndice ser� la clasificaci�n de ese candidato.
	 */
	private List<String> theBallot;

	/**
	 * Constructor predeterminado que instancia la boleta.
	 */
	public Ballot(){
		theBallot = new ArrayList<String>();
	}

	
	public Ballot(String[] candidates){
		this();

		setBallot(candidates);
	}

	
	public Ballot(ArrayList<String> candidates){
		this();

		setBallot(candidates);
	}

	public Ballot(String candidates){
		this();

		setBallot(candidates);
	}

	
	public void setBallot(String[] ballot){
		theBallot.removeAll(theBallot);

		for(String candidate : ballot){
			if(!theBallot.contains(candidate))
				theBallot.add(candidate); //Sets the ballot to the array passed
		}									//in the parameter.
	}

	public void setBallot(ArrayList<String> candidates){
		setBallot(candidates.toArray(new String[candidates.size()]));
	}

	
	public void setBallot(String ballot){
		theBallot.removeAll(theBallot);

		int index = -1; //The index for searching the candidates string.

		char[] separators = {',', ';', '>', '/'};

		do {
			int newIndex = -1;

			for(char c : separators)
				newIndex = Math.max(ballot.indexOf(c, index + 1), newIndex);

			String candidate;
			
			if(newIndex != -1)
				candidate = ballot.substring(index + 1, newIndex).trim();
			else
				candidate = ballot.substring(index + 1).trim();
			
			if(!theBallot.contains(candidate))
				theBallot.add(candidate);

			index = newIndex;

		} while(index != -1);
	}

	
	public String getCandidate(int index){
		try {
			return theBallot.get(index); //Returns the candidate with specified index.
		} catch(IndexOutOfBoundsException e){
			return "";
		}
	}

	public int getBallotLength(){
		return theBallot.size();
	}

	
	public void eliminateCandidate(String candidate){
		if(theBallot.contains(candidate))
			theBallot.remove(getIndex(candidate));
	}

	
	public void eliminateCandidate(int index){
		theBallot.remove(index);
	}


	
	public int getIndex(String candidate){
		return theBallot.indexOf(candidate);
	}

	
	public int getPosition(String candidate){
		return getIndex(candidate) + 1;
	}

	
	public List<String> toList(){
		return theBallot;
	}

	
	public String[] toArray(){
		return theBallot.toArray(new String[theBallot.size()]);
	}
} 
