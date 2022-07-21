
public class Prompt3 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 3: ");
		System.out.println("Character3(String name, int hitpoint, int mana, String job) is overloaded");
		System.out.println("Character3(String name, int hitpoint, int mana, String job, String job2)");
		System.out.println("------------------");
		
		System.out.println("Making new Character");
		System.out.println("Windrunner is a Warrior.");
		Character3 char1 = new Character3("Windrunner", 1000, 100, "Warrior");
		char1.getCharacter();
		
		System.out.println("Making new Character");
		System.out.println("Shadowflame is a Warrior, but also a Berserker.");
		Character3 char2 = new Character3("Shadowflame", 2000, 150, "Warrior", "Berserker");
		char2.getCharacter();
	}
}

class Character3{
	protected String name;
	protected int hp;
	protected int mp;
	protected String job;
	protected String advancedJob;
	
	//original constructor
	public Character3(String name, int hitpoint, int mana, String job) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
		this.job = job;
	}
	
	//overloaded constructor
	public Character3(String name, int hitpoint, int mana, String job, String job2) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
		this.job = job;
		this.advancedJob = job2;
	}
	
	public void getCharacter(){
		if(advancedJob == null) {
			System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nCharacter Class: %s\n\n", 
					name, hp, mp, job);
		}
		else
		{
			System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \nCharacter Class: %s \nCharacter Class 2: %s \n\n", 
					name, hp, mp, job, advancedJob);
		}
	}
	

}