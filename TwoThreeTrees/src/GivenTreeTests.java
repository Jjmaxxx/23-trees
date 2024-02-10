import static org.junit.Assert.*;

import org.junit.Test;


public class GivenTreeTests
{
	//this one works for all right
   	
   public void getSize() {
	   Tree t = new Tree();
	   t.insert(1);
	   t.insert(2);
	   t.insert(3);
	   t.insert(4);
	   t.insert(5);
	   t.insert(6);
	   t.insert(7);
	   t.insert(8);
	   t.insert(9);
	   t.insert(10);
	   t.insert(11);
	   t.insert(12);
	   t.insert(13);
	   t.insert(14);
	   t.insert(15);
	   assertEquals(15,t.size());
	   assertEquals(15,t.get(14));
   }
	
   @Test
   public void testSplitRight() {
	   Tree t = new Tree();
	   t.insert(5);
	   t.insert(10);
	   t.insert(20);
	   t.insert(8);
	   t.insert(7);
	   t.insert(15);
	   t.insert(30);
	   t.insert(11);
	   t.insert(40);
	   t.insert(13);
	   t.insert(50);
	   t.insert(35);
	   t.insert(36);
	   t.insert(37);
//	   for(int i=0;i<14;i++) {
//		   System.out.println("i: "+i+ " " +t.get(i));
//	   }
	   assertEquals(14,t.size());
   }
	
   @Test
   public void testSplitLeft() {
	   Tree t = new Tree();
	   t.insert(50);
	   t.insert(49);
	   t.insert(48);
	   t.insert(47);
	   t.insert(46);
	   t.insert(45);
	   t.insert(44);
	   t.insert(43);
	   t.insert(42);
	   t.insert(41);
	   t.insert(40);
	   t.insert(39);
	   t.insert(38);
	   t.insert(37);
	   t.insert(36);
	   t.insert(99);
	   t.insert(23);
	   t.insert(130);
	   t.insert(86);
	   assertEquals(19,t.size());
//	   int num = 0;
//	   for(int i=36;i<51;i++) {
//		   assertEquals(i,t.get(num));
//		   num+=1;
//	   }
   }

//also works 
	@Test
	public void testSplitMiddle() {
		   Tree t = new Tree();
		   t.insert(20);
		   t.insert(40);
		   t.insert(60);
		   t.insert(80);
		   t.insert(100);
		   t.insert(120);
		   t.insert(50);
		   t.insert(70);
		   t.insert(140);
		   t.insert(10);
		   t.insert(5);
		   t.insert(30);
		   t.insert(35);
		   t.insert(58);
		   t.insert(33);
		   t.insert(55);
		   t.insert(31);
		   t.insert(150);
		   t.insert(160);
		   t.insert(90);
		   t.insert(95);
		   assertEquals(21,t.size());
	}
	
   @Test
   public void singleNodeTree()
   {
      Tree t = new Tree();
      t.insert(9);
      
      assertEquals(1, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      
      t.insert(15);
      assertEquals(2, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      assertEquals(2, t.size(15));
      assertEquals(0, t.size(18));

      t = new Tree();
      t.insert(15);
      t.insert(9);
      assertEquals(2, t.size(9));
      assertEquals(0, t.size(8));
      assertEquals(0, t.size(10));
      assertEquals(2, t.size(15));
      assertEquals(0, t.size(18));
      
      assertEquals(9, t.get(0));
      assertEquals(15, t.get(1));


   }
   
   @Test
   public void oneSplitLeft()
   {
      Tree t = new Tree();
      t.insert(9);
      t.insert(15);
      t.insert(1);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));

      assertEquals(1, t.get(0));
      assertEquals(9, t.get(1));
      assertEquals(15, t.get(2));
      
      assertEquals(3,t.size());
   }
   
   @Test
   public void oneSplitRight()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(9);
      t.insert(15);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));
      
      assertEquals(1, t.get(0));
      assertEquals(9, t.get(1));
      assertEquals(15, t.get(2));
      assertEquals(3,t.size());


   }

   @Test
   public void oneSplitMiddle()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(15);
      t.insert(9);
      
      assertEquals(3, t.size(9));
      assertEquals(1, t.size(15));
      assertEquals(0, t.size(17));
      assertEquals(0, t.size(11));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));
      
      assertEquals(1, t.get(0));
      assertEquals(9, t.get(1));
      assertEquals(15, t.get(2));
      assertEquals(3,t.size());


   }
	@Test
	public void testDuplicaties2() {
		Tree t = new Tree();
	    t.insert(1);
	    t.insert(9);
	    t.insert(15);
	    t.insert(13);
	    t.insert(20);
	    t.insert(7);
	    t.insert(4);
	    t.insert(1);
	    t.insert(9);
	    t.insert(15);
	    t.insert(1);
		assertEquals(7, t.size());
	}
   
   @Test
   public void testDuplicates()
   {
      Tree t = new Tree();
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(1);
      t.insert(9);
      t.insert(15);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);
      t.insert(13);
      t.insert(20);
      t.insert(7);
      t.insert(4);

      assertEquals(7, t.size(9));
      assertEquals(3, t.size(4));
      assertEquals(3, t.size(15));

      assertEquals(0, t.size(12));
      assertEquals(1, t.size(13));
      assertEquals(0, t.size(14));
      assertEquals(0, t.size(19));
      assertEquals(1, t.size(20));
      assertEquals(0, t.size(21));

      assertEquals(1, t.size(1));
      assertEquals(0, t.size(0));
      assertEquals(0, t.size(3));

      assertEquals(0, t.size(6));
      assertEquals(1, t.size(7));
      assertEquals(0, t.size(8));
      
      assertEquals(1, t.get(0));
      assertEquals(4, t.get(1));
      assertEquals(7, t.get(2));
      assertEquals(9, t.get(3));
      assertEquals(13, t.get(4));
      assertEquals(15, t.get(5));
      assertEquals(20, t.get(6));
      assertEquals(7,t.size());

      

   }


}
