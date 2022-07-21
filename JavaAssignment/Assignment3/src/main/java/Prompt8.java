
public class Prompt8 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 8: ");
		System.out.println("Using final with variables, methods, and constructors");
		System.out.println("------------------");
		
		System.out.println("Making new PlayerCharacter");
		PlayerCharacter7 char1 = new PlayerCharacter7("Poolsurge", 2000, 2000, "Stella");
		char1.getCharacter();
		PlayerCharacter8.getStartingLevel();
		
	}
}

//final class
final class PlayerCharacter8 extends Character1{
	protected String player;
	final static private int startinglevel = 1; //final variable
	
	
	public PlayerCharacter8(String name, int hitpoint, int mana, String player) {
		//super constructor
		super(name, hitpoint, mana);
		this.player = player;
	}
	
	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nPlayer: %s \n\n", 
				name, hp, mp, player);
	}
	
	//final method
	final static public void getStartingLevel() {
		System.out.printf("Starting Level: %d \n\n", 
				startinglevel);
	}
	
}