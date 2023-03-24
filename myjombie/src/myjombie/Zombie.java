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
		System.out.println("�Ϲ����� " + this.power + "�� ���ݷ����� ���� :" + " ���� HREO hp : " + hero.getHp());
		
		if(hero.getHp() < 1 ) {
			hero.setHp(0);
			System.out.println("�Ϲ� ���񿡰� HERO�� ���߽��ϴ�.");
			System.out.println("HERO ���...");
			
		}
	}

}
