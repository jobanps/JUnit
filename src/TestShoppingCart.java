import static org.junit.Assert.*;

import org.junit.Test;

import com.sun.source.tree.AssertTree;

public class TestShoppingCart {

	@Test
	public void testCreateCart() {
		ShoppingCart scObj = new ShoppingCart();
		
		assertEquals(0, scObj.getItemCount());
	}
	
	//Test empty cart, compare to 0 to verify all items are remove.
	@Test
	public void testEmptyCart() {
		ShoppingCart scObj = new ShoppingCart();
		Product prodObj = new Product("Oneplue 6T", 799);
		scObj.addItem(prodObj);
		scObj.empty();
		assertEquals(0, scObj.getItemCount());
	}	

	//Testing adding item to cart by comparing price and no of items
	@Test
	public void testAddItemInCart() {
		ShoppingCart scObj = new ShoppingCart();
		scObj.addItem(new Product("Oneplus", 799));
		double expectedAmount = scObj.getBalance() + 1099;
		int itemCount = scObj.getItemCount()+1;
		scObj.addItem(new Product("Oneplus", 1099));
		
		//Compare Balance
		assertEquals(expectedAmount, scObj.getBalance(),0.1);
		
		//Verify if item is update by 1
		assertEquals(itemCount, scObj.getItemCount());
	}
	
	@Test
	public void testRemoveIteminCart() {
		
		ShoppingCart scObj = new ShoppingCart();
		Product pd1 = new Product("Iphone", 1099);
		Product pd2 = new Product("Oneplus", 799);
		scObj.addItem(pd1);
		scObj.addItem(pd2);
		int itemCount = scObj.getItemCount() - 1;
		try {
			scObj.removeItem(pd1);
			
		} catch (ProductNotFoundException e) {
			fail(e.getMessage());
		}
			
		//Verify if item is decremented by  by 1
		assertEquals(itemCount, scObj.getItemCount());
		
	}
	
	@Test
	public void testRemoveIteminCartNoProduct() {
		
		ShoppingCart scObj = new ShoppingCart();
		scObj.addItem(new Product("Oneplus", 799));
		
		
		try {
			scObj.removeItem(new Product("Iphone", 799));
			fail("Test case fails");
		} catch (ProductNotFoundException e) {
			assertTrue(true);
		}
			
	
	}
}
