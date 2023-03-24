package myjombie;

import java.util.Random;

abstract public class Unit {
	private int pos;
	private int hp;
	public int maxPower; // 최대 공격력
	Random ran;
	
	public Unit(int pos, int hp, int maxPower) {
		this.pos = pos;
		this.hp = hp;
		this.maxPower = maxPower;
		this.ran = new Random();
	}
	
	public int getPos() {
		return this.pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getHp() {
		return this.hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMax() {
		return this.maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	public void move() {
		if(this.pos <= 10) {
			pos++;
			System.out.println("HERO가 "+this.pos+"로 이동");
		}
	}
	abstract void attack(Unit unit);

}
