package myjombie;

public class Hero extends Unit {
	public int power; // ���� ���ݷ�
	public int potion; // ���� ��

	public Hero(int pos, int hp, int maxPower, int potion) {
		super(pos, hp, maxPower);
		this.potion = potion;
	}

	public int getPotion() {
		return this.potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}

	@Override
	public void attack(Unit worker) {
		this.power = ran.nextInt(maxPower) + 1;
		if (worker instanceof Boss) {
			Boss boss = (Boss) worker;
			if (boss.getShield() - this.power > 0) {
				boss.setShield(boss.getShield() - this.power);
			} else {
				boss.setShield(0);
				int temp = boss.getShield() - this.power;
				boss.setHp(boss.getHp() + temp);
				if (boss.getHp() < 0) {
					boss.setHp(0);
					System.out.println("BOSS�� óġ�ߴ�!!!");
					this.setMaxPower(getMax()+10);
					this.potion += 3;
					System.out.println("���� 3�� ȹ��");
				}
			}
			System.out.println("����ΰ� " + this.power + "�� ���ݷ����� ���� :" + " ���� Boss hp : " + boss.getHp()
					+ "  ���� Boss Shield : " + boss.getShield());
		} else {
			Zombie zom = (Zombie) worker;
			if (zom.getHp() - this.power < 1) {
				zom.setHp(0);
				System.out.println("���� óġ�ߴ�...");
				
				int item = ran.nextInt(3);
				if(item > 0) {
				this.potion += item;
				System.out.println("���� "+item+"�� ȹ��");
				}

			} else {
				zom.setHp(zom.getHp() - this.power);
			}

			System.out.println("����ΰ� " + this.power + "�� ���ݷ����� ���� :" + " ���� zom hp : " + zom.getHp());
		}
	}

	public void recovery() {
		if (this.potion > 0) {
			
			if (this.getHp() == 200) {
				System.out.println("hp�� ���� ���ֽ��ϴ�.");
			} else {
				this.setHp(this.getHp() + 30);
				if (this.getHp() > 200) {
					this.setHp(200);
				}
				this.potion--;
				this.setPotion(potion);
			}
		} else {
			System.out.println("������ ���� �����ϴ�...");
		}
	}
}
