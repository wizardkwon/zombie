package myjombie;

import java.util.Random;

public class Boss extends Zombie{
	Random ran = new Random();
	private int shield;
	
	public Boss (int pos, int hp, int maxPower, int shield) {
		super(pos, hp, maxPower);
		this.shield = shield;
	}
	
	public int getShield() {
		return this.shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	@Override
	public void attack(Unit hero) {
		
		super.power = this.ran.nextInt(super.maxPower)+1;
		int criAtt = this.ran.nextInt(5);
		if(criAtt == 2) {
			hero.setHp(hero.getHp()-(super.power*criAtt));
		}else {
			hero.setHp(hero.getHp()-super.power);
		}
		if(hero.getHp() < 1) {
			hero.setHp(0);
			System.out.println("�ᱹ BOSS���� HERO�� ���߽��ϴ�.");
			System.out.println("HERO ���...");
		}
		System.out.println("Boss���� " + this.power + "�� ���ݷ����� ���� :" + " ���� HREO hp : " + hero.getHp());
	}
	
}
