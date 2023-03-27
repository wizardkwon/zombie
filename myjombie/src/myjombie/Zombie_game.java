package myjombie;

import java.util.Random;
import java.util.Scanner;

public class Zombie_game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		Hero hero = new Hero(1, 200, 40, 2); // ��ġ, ü��, �ִ���ݷ�, ����
		Zombie zom = new Zombie(0, 100, 5); // ��ġ, ü��, �ִ���ݷ�
		Boss boss = new Boss(0, 150, 10, 20); // ��ġ, ü��, �ִ���ݷ�, ����

		int mapSize = 10;
		int level = 1;
		int hPos = 1;
		int zPos = ran.nextInt(2) + 3; // ���� ��ġ ���� 3~4
		int bPos = ran.nextInt(3) + 7; // ���� ��ġ ���� 7~9
		int step = 0; // ����� �̵��� ��Ʈ ��� ��
		zom.setPos(zPos);
		boss.setPos(bPos);

		boolean check = false;
	
		while (!check) {
		
			System.out.println("���� ������ �� �� ���� ���̷����� ���� �����α��� 30%�� �׾��� ");
			System.out.println("");
			hero.setPos(hPos);
			System.out.println("[1] �̵� , [2] ȸ���ϱ� (��������: " + hero.getPotion() + ")");
			int move = scan.nextInt();
			if (move == 1 && hPos <= mapSize) {
				hPos += 1;
				if (hPos == 10) {
					System.out.println("���� ��� Ż�� ����!!!!!");
					System.out.println("���� STAGE�� �̵��Ͻðڽ��ϱ�? (y/n)");
					String sel = scan.next();
					if (sel.equals("n")) {
						System.out.println("����!@@!");
						check = true;
					} else {
						level++; // stage �Ѿ������ ���� �ɷ� ���׷��̵�
						hPos = 1;
						hero = new Hero(1, 250, 30 + (5 * level), 3 + hero.getPotion());
						zom = new Zombie(0, 150 + (10 * level), 15 * level);
						boss = new Boss(0, 200 + (15 * level), 20 + (level * 5), 40 + (level + 4));
						zPos = ran.nextInt(2) + 3;
						bPos = ran.nextInt(3) + 7;
						step = 0;
						zom.setPos(zPos);
						boss.setPos(bPos);
					}
				}
				System.out.println("HERO ��ġ: " + hPos);
				if (hPos == zPos) {
					System.out.println(" ���� ��Ÿ����!!!!");
					while (true) {
						System.out.println("[1]�����ϱ�  [2] ȸ���ϱ� (��������:" + hero.getPotion() + ")");
						int sel = scan.nextInt();
						if (sel == 1) {
							
							hero.attack(zom);
							zom.attack(hero);
							if (zom.getHp() == 0) {
								break;
							}
							if (hero.getHp() == 0) {
								break;
							}
						} else if (sel == 2) {
							hero.recovery();
							System.out.println("HERO ü��: " + hero.getHp());
						}
					}
					if (hero.getHp() == 0) {
						check = true;
					}

				} else if (hPos == bPos) {
					System.out.println(" BOSS ���� ��Ÿ����!!!!");
					while (true) {
						System.out.println("[1]�����ϱ�  [2] ȸ���ϱ� (��������:" + hero.getPotion() + ")");
						int sel = scan.nextInt();
						if (sel == 1) {
							hero.attack(boss);
							boss.attack(hero);
						
							if (boss.getHp() == 0) {
								break;
							}
							if (hero.getHp() == 0) {
								break;
							}
						} else if (sel == 2) {
							hero.recovery();
							System.out.println("HERO ü��: " + hero.getHp());
						}
					}
					if (hero.getHp() == 0) {
						check = true;
					}
				} else {
					System.out.println("step: " + step);
					for (int i = 0; i < 10; i++) {
						if (step == 1) {
							System.out.println(" HERO : �δ��ϴ�....");
							break;
						} else if (step == 3 || step == 5) {
							System.out.println(" HERO : ������ ����� ��������...");
							break;
						}
					}
					step++;
				}
			} else if (move == 2) {
				hero.recovery();
				System.out.println("HERO ü��: " + hero.getHp());
			} else {
				System.out.println("�̵��Ұ�");

			}

		}

	}

}
