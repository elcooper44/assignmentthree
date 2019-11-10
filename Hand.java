package com.bham.pij.assignments.pontoon;
import java.util.ArrayList;
public class Hand {
	private ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Integer> numericalValue = new ArrayList<Integer>();
	public Hand() {
		ArrayList<Card> hand = new ArrayList<Card>();
		
	}
	public void addCard(Card c) {
		hand.add(c);
	}
	public int getHandSize() {
		return hand.size();
	}
	public Card getCard(int i) {
		return hand.get(i);
	}
	public String showHand() {
		String str = "";
		for (int i = 0 ; i < hand.size(); i++) {
			str = str.concat(hand.get(i).toString() + " ");
		}
		return str;
	}
	public ArrayList<Integer> getNumericalValue (){
		ArrayList<Integer> numValues = new ArrayList<Integer>();
		ArrayList<Integer> numericalValues = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.get(i);
			numValues.addAll(card.getNumericalValue());
			
			if (card.getValue() == "ACE") {
				if (numericalValues.size() == 0) {
					numericalValues.add(0,1);
					numericalValues.add(1,11);
				}
				else if (numericalValues.size() > 0) {
					numericalValues.add(numericalValues.get(numericalValues.size()-1)+1);
					for (int j = 0; j < numericalValues.size()-1; j++) {
						numericalValues.set(j, numericalValues.get(j)+11);
					}
				}
			}
			else {
				if (numericalValues.size() == 0) {
					numericalValues.add(numValues.get(0));
				}
				else {
					for (int j = 0; j < numericalValues.size(); j++) {
						numericalValues.set(j, numericalValues.get(j)+numValues.get(0));
					}
				}
			}
		}
		return numericalValues;

	}
}

