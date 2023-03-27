package myjombie;

import java.util.Random;

public class Zombie_map {
	Zombie zom = new Zombie(0, 100, 5); // 위치, 체력, 최대공격력
	Boss boss = new Boss(0, 150, 10, 20); // 위치, 체력, 최대공격력, 방어력
	Random ran;
	int zPos = ran.nextInt(2) + 3; // 좀비 위치 랜덤 3~4
	int bPos = ran.nextInt(3) + 7; // 보스 위치 랜덤 7~9
	
	public Zombie_map (){
		
	}
}
