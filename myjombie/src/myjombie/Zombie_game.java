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

		int map[] = new int[10];
		int h = -1, z = -1, b = -1;
		boolean check = false;
		int deadZom = 0;
		while (!check) {
			for (int i = 0; i < map.length; i++) {
				if (i == hPos) {
					map[i] = hPos;
				} else if (i == zPos) {
					if (zom.getHp() == 0) {
						map[z] = 0;
					} else {
						map[i] = zPos;
					}
				} else if (i == bPos) {
					if (boss.getHp() == 0) {
						map[b] = 0;
					} else {
						map[i] = bPos;
					}
				}
			}
			for (int i = 0; i < map.length; i++) {
				if (map[i] == 0) {
					System.out.print("__");
				} else if (map[i] == hPos) {
					System.out.print("옷");
					h = i;
				} else if (map[i] == zPos) {
					System.out.print("Z");
					z = i;
				} else if (map[i] == bPos) {
					System.out.print("B");
					b = i;
				}
			}
	
			map[h] = 0;
			System.out.println();
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
							int count = 5;
							while (count > 0) {
								try {
									if (count == 5) {
										System.out.println("___옷□□§〓〓▷____Z");
									} else if (count == 4) {
										System.out.println("_______옷□□§〓〓▷_Z");
									} else if (count == 3) {
										System.err.println("__________옷□□§〓Z〓▷  zom: '크아악!!!'");
									} else if (count == 2) {
										System.out.println("______옷□□§〓〓▷__Z");
									} else if (count == 1) {
										System.out.println("____옷□□§〓〓▷_____Z");
									}
									Thread.sleep(300);
								} catch (Exception e) {
									e.printStackTrace();
								}
								count--;
							}

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
							int count = 5;
							while (count > 0) {
								try {
									if (count == 5) {
										System.out.println("___옷□□§〓〓▷____B");
									} else if (count == 4) {
										System.out.println("_______옷□□§〓〓▷_B");
									} else if (count == 3) {
										System.err.println("__________옷□□§〓B〓▷  zom: '크아악!!!'");
									} else if (count == 2) {
										System.out.println("______옷□□§〓〓▷__B");
									} else if (count == 1) {
										System.out.println("____옷□□§〓〓▷_____B");
									}
									Thread.sleep(300);
								} catch (Exception e) {
									e.printStackTrace();
								}
								count--;
							}
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
							System.out.println(" HERO : 조용한 골목이군..");
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
