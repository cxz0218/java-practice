package charater;

public class Item {
	protected String name;
	
	protected int price;
	
	long val = 26L;
	
	int a16 = 0x56;
	
	int a8 = 056;
	
	int a2 = 010101;
	
	public void effect (){
		 System.out.println("��Ʒʹ�ú󣬿�����Ч��");
	}
	
    public String toString(){
        return name + price;
    }
     
    public void finalize(){
        System.out.println(this + "���Ӣ�����ڱ�����");
    }
    
    public boolean equals(Object o){
    	if ( o instanceof Item)
    	{
    		Item h = (Item) o;
    		return h.price == this.price;
    	}
    	return false;
    	
    }
	
	public static void main(String[] args) {
		
		Item one = new Item ();
		one.name = "Ѫƿ";
		one.price = 50 ;

		Item two = new Item ();
		two.name = "��Ь";
		two.price = 300 ;
		
		Item three = new Item ();
		three.name = "����";
		three.price = 50 ;
		System.out.println(one);
		System.out.println(one.equals(two));
		System.out.println(one.equals(three));
//		System.out.println(one.name);
//		
//		System.out.println(Integer.toBinaryString(three.price));
		
		//��д
//		Item ad = new Item();
//		ad.effect();
//		
//		MagicPotion sg = new MagicPotion();
//		sg.effect();
		
	}
}
