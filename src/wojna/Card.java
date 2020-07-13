package wojna;

import java.util.Formatter; 

public class Card {
	private String figure;
	private String suit;
	private byte cardPower;
	private byte suitPower;
	
	Card(String figure, String suit){
//		System.out.println("I'm in constructor with ALL parameters in class Card");
		this.figure = figure;
		this.suit = suit;
		giveMeCardPower(figure);
		giveMeColorPower(suit);		
	}
	
	
	private void giveMeCardPower(String figure){
		switch (figure) {
		case "As": 
			cardPower = 14;
			break;
		case "King":
			cardPower = 13;
			break;
		case "Queen":
			cardPower = 12;
			break;
		case "Jack":
			cardPower = 11;
			break;
		case "10":
			cardPower = 10;
			break;
		case "9":
			cardPower = 9;
			break;
		case "8":
			cardPower = 8;
			break;
		case "7":
			cardPower = 7;
			break;
		case "6":
			cardPower = 6;
			break;
		case "5":
			cardPower = 5;
			break;
		case "4":
			cardPower = 4;
			break;
		case "3":
			cardPower = 3;
			break;
		case "2":
			cardPower = 2;
			break;
		case "JOKER":
			cardPower = 15;
			break;
		}
		
	}

	private void giveMeColorPower(String suit) {
		switch(suit) {
		case "Heart":
			suitPower = 4;
			break;
		case "Diamond":
			suitPower = 3;
			break;
		case "Club":
			suitPower = 2;
			break;
		case "Spade":
			suitPower = 1;
			break;
		}
	}
	
	protected String getFigure() {
		return figure;
	}
	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		formatter.format("| Card figure:  %-5s | Card color: %-7s | Card power: %-2d | Card color power: %-1d |", figure, suit, cardPower, suitPower);
		String formattedString = formatter.toString();
		formatter.close();
		return formattedString;
	}

	protected byte getCardPower() {
		return cardPower;
	}

	protected byte getSuitPower() {
		return suitPower;
	}
}
