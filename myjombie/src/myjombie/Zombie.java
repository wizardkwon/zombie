package myjombie;

public class Zombie extends Unit {
	public int power;
	
	public Zombie(int pos, int hp, int maxPower) {
		super(pos, hp, maxPower);
	}
	@Override
	public void attack(Unit hero) {
		int zomAtt = ran.nextInt(maxPower)+1;
		this.power = zomAtt;
		hero.setHp(hero.getHp()-zomAtt);
		System.out.println("일반좀비가 " + this.power + "의 공격력으로 공격 :" + " 현재 HREO hp : " + hero.getHp());
		
		if(hero.getHp() < 1 ) {
			hero.setHp(0);
			System.out.println("일반 좀비에게 HERO가 당했습니다.");
			System.out.println("HERO 사망...");
			
		}
	}

}
