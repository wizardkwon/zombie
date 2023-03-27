package myjombie;

import java.util.Random;
import java.util.Scanner;

public class Zombie_game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();

		Hero hero = new Hero(1, 200, 40, 2); // 위치, 체력, 최대공격력, 포션
		Zombie zom = new Zombie(0, 100, 5); // 위치, 체력, 최대공격력
		Boss boss = new Boss(0, 150, 10, 20); // 위치, 체력, 최대공격력, 방어력

		int mapSize = 10;
		int level = 1;
		int hPos = 1;
		int zPos = ran.nextInt(2) + 3; // 좀비 위치 랜덤 3~4
		int bPos = ran.nextInt(3) + 7; // 보스 위치 랜덤 7~9
		int step = 0; // 히어로 이동시 멘트 출력 용
		zom.setPos(zPos);
		boss.setPos(bPos);

		boolean check = false;
	
		while (!check) {
		
			System.out.println("현재 지구는 알 수 없는 바이러스로 인해 세계인구의 30%가 죽었고 ");
			System.out.println("");
			hero.setPos(hPos);
			System.out.println("[1] 이동 , [2] 회복하기 (보유물약: " + hero.getPotion() + ")");
			int move = scan.nextInt();
			if (move == 1 && hPos <= mapSize) {
				hPos += 1;
				if (hPos == 10) {
					System.out.println("좀비 골목 탈출 성공!!!!!");
					System.out.println("다음 STAGE로 이동하시겠습니까? (y/n)");
					String sel = scan.next();
					if (sel.equals("n")) {
						System.out.println("종료!@@!");
						check = true;
					} else {
						level++; // stage 넘어갈때마다 몬스터 능력 업그레이드
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
				System.out.println("HERO 위치: " + hPos);
				if (hPos == zPos) {
					System.out.println(" 좀비가 나타났다!!!!");
					while (true) {
						System.out.println("[1]공격하기  [2] 회복하기 (보유물약:" + hero.getPotion() + ")");
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
							System.out.println("HERO 체력: " + hero.getHp());
						}
					}
					if (hero.getHp() == 0) {
						check = true;
					}

				} else if (hPos == bPos) {
					System.out.println(" BOSS 좀비가 나타났다!!!!");
					while (true) {
						System.out.println("[1]공격하기  [2] 회복하기 (보유물약:" + hero.getPotion() + ")");
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
							System.out.println("HERO 체력: " + hero.getHp());
						}
					}
					if (hero.getHp() == 0) {
						check = true;
					}
				} else {
					System.out.println("step: " + step);
					for (int i = 0; i < 10; i++) {
						if (step == 1) {
							System.out.println(" HERO : 싸늘하다....");
							break;
						} else if (step == 3 || step == 5) {
							System.out.println(" HERO : 음산한 기운이 느껴진다...");
							break;
						}
					}
					step++;
				}
			} else if (move == 2) {
				hero.recovery();
				System.out.println("HERO 체력: " + hero.getHp());
			} else {
				System.out.println("이동불가");

			}

		}

	}

}
