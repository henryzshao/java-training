
public class Prompt5 {
	public static void execute() {
		System.out.println("------------------------------------");
		System.out.println("Prompt 5: ");
		System.out.println("Object5 and Character5 extends abstract class Entity5");
		System.out.println("------------------");
		
		System.out.println("Making new Character");
		Character5 char1 = new Character5("Windrunner", 1000, 100);
		char1.getCharacter();
		
		System.out.println("Making new Object");
		Object5 char2 = new Object5("Treasure Chest", "This container is full of gold!");
		char2.getCharacter();
		
	}
}

//Abstract Class
abstract class Entity5{
	public abstract void getCharacter();
}

//subclass
class Character5 extends Entity5{
	protected String name;
	protected int hp;
	protected int mp;
	
	public Character5(String name, int hitpoint, int mana) {
		this.name = name;
		this.hp = hitpoint;
		this.mp = mana;
	}

	@Override
	public void getCharacter() {
		System.out.printf("Character Name: %s \nCharacter HP: %d \nCharacter MP: %d \n\n", 
				name, hp, mp);
		
	}
}

//subclass
class Object5 extends Entity5{
	protected String name;
	protected String desc;
	
	public Object5(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	@Override
	public void getCharacter() {
		System.out.printf("Object Name: %s \nObject Description: %s\n\n", 
				name, desc);
		
	}
}