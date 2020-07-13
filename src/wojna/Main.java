package wojna;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
		public static ArrayList<Card> table = new ArrayList<Card>();
		
private static Player[] createPlayersAndGiveThemCards(String name, String name2, ArrayList<Card> listOfCards) {
		ArrayList<Card> firstGroupOfCards = new ArrayList<Card>(listOfCards.subList(0, listOfCards.size()/2));
		ArrayList<Card> secondGroupOfCards = new ArrayList<Card>(listOfCards.subList(listOfCards.size()/2, listOfCards.size()));
		Player one = new Player(name, firstGroupOfCards);
		Player two = new Player(name2, secondGroupOfCards);
		Player[] players = {one, two};
		return players;
		
	}
	
private static ArrayList<Card> createCards() {
		String [] figures = {"As", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
		String [] suits = {"Heart", "Diamond", "Club", "Spade"};
		DeckOfCards deck = new DeckOfCards();
		ArrayList<Card> listOfCards = deck.listOfCards;
		try {listOfCards = deck.cardsFactory(figures, suits);} catch (Exception e) {e.printStackTrace();}
		Collections.shuffle(listOfCards);
		return listOfCards;
	}

private static void thisIsWar(Player one, Player two) {
	System.out.println("This is War!----------------------------");
	if (one.howManyCards() > 0 && two.howManyCards() > 0) {
		try 
		{
		System.out.format("Players are preparing to war. | %-5s has: %-4d cards || vs %-5s has: %-4d cards |", one.getName(), one.howManyCards(), two.getName(), two.howManyCards());
		System.out.println("Cards on the table before cards added: " + table.size());
		Card card1 = one.getCard(); Card card2 = two.getCard(); table.add(card1); table.add(card2);
		card1 = one.getCard(); card2 = two.getCard();
		System.out.println("Cards on the table after 2 cards added: " + table.size());
		System.out.println("FACE-OFF: " + card1.toString() + " vs " + card2.toString());
		if (card1.getCardPower() > card2.getCardPower()) {
			System.out.println("Player " +one.getName() +" wins battle in war");
			table.add(card1); table.add(card2);
			System.out.println("Amount of cards in table: " + table.size());
			one.putCardsFromTable();
			System.out.println(one.toString() + two.toString());
			System.out.println("I'am leaving war method");
		}
		else if (card1.getCardPower() < card2.getCardPower()) {
			System.out.println("Player " +two.getName() +" wins battle in war");
			table.add(card1); table.add(card2);
			System.out.println("Amount of cards in table: " + table.size());
			two.putCardsFromTable();
			System.out.println(one.toString() + two.toString());
			System.out.println("I'am leaving war method");
		}
		else {
			System.out.println("Card's powers IN WAR are the same so this is another war!!!!!!!");
			table.add(card1); table.add(card2); System.out.println("Amount of cards in table: " + table.size());
			System.out.println(one.toString() + two.toString());
			card1 = null; card2 = null;
			
			thisIsWar(one, two);
		}
		}
		catch(NoCardExeption e) {
			e.printStackTrace();
			
				
		}
	}
	else {
		if (one.howManyCards() == 0) {
//			System.out.println("PLAYER " + two.getName() + " WON THIS GAME !!!");
			two.putCardsFromTable();
			System.out.println("I'am leaving war method");
		}
		if (two.howManyCards() == 0)
//			System.out.println("PLAYER " + one.getName() + " WON THIS GAME !!!");
			one.putCardsFromTable();
			System.out.println("I'am leaving war method");
	}
}		

	

	public static void main(String[] args) {
		System.out.println("************ WELCOME IN WAR GAME ************");
		ArrayList<Card> listOfCards = createCards();
		Player [] listOfPlayers = createPlayersAndGiveThemCards("Dawid", "Pawe³", listOfCards);
		Player dawid = listOfPlayers[0]; 	Player pawel = listOfPlayers[1]; 	listOfCards.clear();
		Card joker = new Card("JOKER", "Black"); Card joker2 = new Card("JOKER", "Red");
		pawel.putCard(joker); dawid.putCard(joker2);
		System.out.println("Dawid: ");
		dawid.showMeYourCards(); 
		System.out.println();
		System.out.println("Pawe³: ");
		pawel.showMeYourCards(); 
		System.out.println();

		
		while (dawid.howManyCards() > 0 && pawel.howManyCards() > 0) {
		try {
			
			Card card1 = dawid.getCard(); Card card2 = pawel.getCard();
			if (card1.getCardPower() > card2.getCardPower()) {
				
				System.out.println(card1.toString() + " vs " + card2.toString());
				System.out.format("Player %-6s wins this battle ", dawid.getName()); 
				
				dawid.putCard(card2);
				dawid.putCard(card1);
				System.out.println(dawid.toString() + pawel.toString());
			}
			else if (card1.getCardPower() < card2.getCardPower()) {
				System.out.println(card1.toString() + " vs " + card2.toString());
				System.out.format("Player %-6s wins this battle ", pawel.getName());
				
				pawel.putCard(card1);
				pawel.putCard(card2);
				System.out.println(dawid.toString() + pawel.toString());
			}
			else {
				System.out.println("Card's powers are the same-------------------- ");
				System.out.println(dawid.toString() + pawel.toString());
				System.out.println(card1.toString() + " vs " + card2.toString());
				table.add(card1); table.add(card2); System.out.println("Amount of cards in table: " + table.size());
				card1 = null; card2 = null;
				thisIsWar(dawid, pawel);
			}
			}
		 catch (NoCardExeption e) {
			
			e.toString();
			e.printStackTrace();
			
		}
		}
		if (dawid.howManyCards() == 0) {
			System.out.println("PLAYER " + pawel.getName() + " WON THIS GAME !!!");
			pawel.putCardsFromTable();
			System.out.println("I'am leaving this game");
		}
		if (pawel.howManyCards() == 0)
			System.out.println("PLAYER " + dawid.getName() + " WON THIS GAME !!!");
			dawid.putCardsFromTable();
			System.out.println("I'am leaving this game");
			
		System.out.println(dawid.toString() + pawel.toString());
		
		System.out.println("Dawid: ");
		dawid.showMeYourCards(); 
		System.out.println();
		System.out.println("Pawe³: ");
		pawel.showMeYourCards(); 
		System.out.println("Jokers with Pawe³: " + pawel.findTheJoker());
		System.out.println("Jokers with Dawid: " + dawid.findTheJoker());
		
	}

	

}
