package myjombie;

import java.util.Random;

public class Zombie_map {
	Zombie zom = new Zombie(0, 100, 5); // ��ġ, ü��, �ִ���ݷ�
	Boss boss = new Boss(0, 150, 10, 20); // ��ġ, ü��, �ִ���ݷ�, ����
	Random ran;
	int zPos = ran.nextInt(2) + 3; // ���� ��ġ ���� 3~4
	int bPos = ran.nextInt(3) + 7; // ���� ��ġ ���� 7~9
	
	public Zombie_map (){
		
	}
}
