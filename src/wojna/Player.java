package wojna;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Player {
	private ArrayList<Card> myCards;
	private String name;
	private int amountOfCards;
	
	public Player(String name, ArrayList<Card> cards) {
		
		this.name = name;
		this.myCards = cards;
		
	}
	protected String getName() {
		return name;
	}
	protected int howManyCards() {
		this.amountOfCards = myCards.size();
		return this.amountOfCards;
	}
	protected void showMeYourCards(){
		Iterator<Card> iter = myCards.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}	
	protected Card getCard() throws NoCardExeption {
		if (myCards.size()>0) {
		Card card = myCards.get(0);
		myCards.remove(0);
		return card;}
		else {
			throw new NoCardExeption("Player " + this.name + " loose! He's don't have any cards ", this.name);
		}
	}
	protected void putCard(Card card) {
		myCards.add(card);
	}
	protected void putCardsFromTable() {
		Iterator<Card> iter = Main.table.iterator();
		while(iter.hasNext())
			{myCards.add(iter.next());}
		Main.table.clear();
		System.out.println("Cards in table after clearing: " + Main.table.size());
	}
	
	protected byte findTheJoker () {
		byte stream = (byte) myCards.stream().filter((Card) -> (Card.getFigure() == "JOKER")).count();
		return stream;
	}
	
	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("| Player:  %-2s | Amount of cards: %-2d |", name, howManyCards());
		String formattedString = formatter.toString();
		formatter.close();
		return formattedString;
	}
	
		
}

