package wojna;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
	ArrayList<Card> listOfCards = new ArrayList<>();

	public DeckOfCards() {
//		System.out.println("I'm in constructor with no parameters in class DeckOfCards");
		
	}
	
	public int howManyCardsInDeck() {
		return listOfCards.size();
	}
	protected ArrayList<Card> cardsFactory(String[] figures, String[] suits) throws Exception {
		
		try {
			for(String figure: figures) {
				for(String suit: suits) {
					Card card = new Card(figure, suit);
					listOfCards.add(card);
				}
			}
		} catch (Exception e) {
			
			throw e;
		}
		return listOfCards;
	
}

	
}
