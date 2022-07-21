
public class Prompt2 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 2: ");
		System.out.println("takeDamage(int hp) is overloaded");
		System.out.println("takeDamage(int hp, int mp)");
		System.out.println("------------------");
		
		System.out.println("Making new Character");
		String name = "Windrunner";
		int hp = 1000;
		int mana = 100;
		Character2 char1 = new Character2(name, hp, mana);
		char1.getCharacter();
		
		//takeDamage(int)
		char1.takeDamage(100);
		char1.getCharacter();
		
		//takeDamage(int, int) - overloaded
		char1.takeDamage(100,10);
		char1.getCharacter();
		
		
		
		
	}
}

class Character2{
	protected String name;
	protected int hp;
	protected int mp;
	
	public Character2(String name, int hitpoint, int mana) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
	}
	
	public void getCharacter(){
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \n\n", 
				name, hp, mp);
	}
	
	//original method
	public void takeDamage(int hp) {
		this.hp = this.hp - hp;
		System.out.printf("%s has taken %d damage!\n", 
				name, hp);
	}
	
	//overloaded method
	public void takeDamage(int hp, int mp) {
		this.hp = this.hp - hp;
		this.mp = this.mp - mp;
		System.out.printf("%s has taken %d damage and was burned for %d mana!\n", 
				name, hp, mp);
	}
}