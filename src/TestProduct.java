import static org.junit.Assert.*;

import org.junit.Test;

public class TestProduct {

	@Test
	public void testAddProduct() {
		// create a new Product
		Product prodObj = new Product("Oneplus 6T", 799);
		
		// Test if name of new Product is correct
		assertEquals("Oneplus 6T", prodObj.getTitle());
		
		// Test if price of new Product is correct
		assertEquals(799, prodObj.getPrice(),0);
	}

	@Test
	public void testTwoProductsEqual() {
		// create a new Product
		Product prodObj1 = new Product("Oneplus 6T", 799);
		Product prodObj2 = new Product("Oneplus 6T", 799);
		
		// Test if name of two Products is same
		assertEquals(prodObj1.getTitle(), prodObj2.getTitle());
		
		
	}
}
