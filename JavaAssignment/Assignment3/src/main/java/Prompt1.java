
public class Prompt1 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 1: ");
		System.out.println("PlayerCharacter inherits Character");
		System.out.println("------------------");
		
		System.out.println("Making new Character");
		String name = "Windrunner";
		int hp = 1000;
		int mana = 100;
		Character1 char1 = new Character1(name, hp, mana);
		char1.getCharacter();
		
		System.out.println("Making new PlayerCharacter");
		String player = "Emily";
		PlayerCharacter2 char2 = new PlayerCharacter2(name, hp, mana, player);
		char2.getCharacter();
		
	}
}

//parent class
class Character1{
	protected String name;
	protected int hp;
	protected int mp;
	protected int maxlevel = 100;
	
	public Character1(String name, int hitpoint, int mana) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
	}
	
	public void getCharacter(){
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \n\n", 
				name, hp, mp);
	}
}

//child class
class PlayerCharacter2 extends Character1{
	protected String player;
	
	public PlayerCharacter2(String name, int hitpoint, int mana, String player) {
		super(name, hitpoint, mana);
		this.player = player;
	}
	
	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nPlayer: %s \n\n", 
				name, hp, mp, player);
	}
}