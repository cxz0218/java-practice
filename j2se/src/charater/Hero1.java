package charater;

public class Hero1 {
	public static void main(String[] args) {
		HeroType type = HeroType.TANK;
		switch(type) {
		case TANK:
			System.out.println("̹��");
			break;
        case WIZARD:
            System.out.println("��ʦ");
            break;
        case ASSASSIN:
            System.out.println("�̿�");
            break;
        case ASSIST:
            System.out.println("����");
            break;
        case WARRIOR:
            System.out.println("��ս");
            break;
        case RANGED:
            System.out.println("Զ��ս");
            break;
        case PUSH:
            System.out.println("�ƽ�");
            break;
        case FARMING:
            System.out.println("��Ұ");
            break;
		}
		
		for (HeroType t : HeroType.values()){
			System.out.println(t);
		}
	}
}
