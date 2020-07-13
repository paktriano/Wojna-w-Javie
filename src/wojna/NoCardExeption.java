package wojna;

public class NoCardExeption extends Exception {
	private String nameOfPlayer;
	public NoCardExeption(String errorMessage, String name) {
		super(errorMessage);
		System.out.println("NoCardExeption is trown");
		this.nameOfPlayer = name;
	
	}
	
	public String getNameOFPlayer() {
		return nameOfPlayer;
	}
	
	@Override
	public String toString() {
		return "Player " + nameOfPlayer + " lose, because there is not enough cards in his deck ";
	}
}
