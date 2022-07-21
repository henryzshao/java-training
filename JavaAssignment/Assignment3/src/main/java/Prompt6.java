
public class Prompt6 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 6: ");
		System.out.println("Character6 implements interface Entity6");
		System.out.println("------------------");
		
		System.out.println("Making new Character");
		Character5 char1 = new Character5("Flamesurge", 900, 300);
		char1.getCharacter();
		
	}
}

//interface
interface Entity6{
	public void getCharacter();
}

//subclass
class Character6 implements Entity6{
	protected String name;
	protected int hp;
	protected int mp;
	
	public Character6(String name, int hitpoint, int mana) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
	}

	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \n\n", 
				name, hp, mp);
		
	}
}