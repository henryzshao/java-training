
public class Prompt7 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 7: ");
		System.out.println("Using super with variables, methods, and constructors");
		System.out.println("------------------");
		
		System.out.println("Making new PlayerCharacter");
		PlayerCharacter7 char1 = new PlayerCharacter7("Blossomfire", 4000, 1250, "Lily");
		char1.getCharacter();
		char1.getMaxLevel();
		char1.omitPlayer();
		
	}
}

class PlayerCharacter7 extends Character1{
	public String player;
	
	public PlayerCharacter7(String name, int hitpoint, int mana, String player) {
		//super constructor
		super(name, hitpoint, mana);
		this.player = player;
	}
	
	public void getMaxLevel() {
		System.out.printf("Max Level: %d \n\n", 
				super.maxlevel); //super variable
	}
	
	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nPlayer: %s \n\n", 
				name, hp, mp, player);
	}
	
	public void omitPlayer() {
		super.getCharacter(); //super method
	}
	
}