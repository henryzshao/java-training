
public class Prompt4 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 4: ");
		System.out.println("getCharacter() overrides getCharacter()");
		System.out.println("------------------");
		
		System.out.println("Making new PlayerCharacter");
		Character1 char2 = new PlayerCharacter4("Windrunner", 1000, 100, "Emily");
		char2.getCharacter();
		
	}
}

class PlayerCharacter4 extends Character1{
	public String player;
	
	public PlayerCharacter4(String name, int hitpoint, int mana, String player) {
		super(name, hitpoint, mana);
		this.player = player;
	}
	
	//overriding method
	@Override
	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nPlayer: %s \n\n", 
				name, hp, mp, player);
	}
}