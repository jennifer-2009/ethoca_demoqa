package com.demoqa.store.test;

import org.json.JSONObject;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoqa.store.page.AccessoriesPage.products;
import com.demoqa.store.util.Utility;

public class TransactionTest extends BaseTest {

	@Test
	public void verify_product_added_in_Cart() {
		
		// Go to Accessories page
		page.Navigation(driver).select_product("Accessories");

		// Add the product to cart and then check out
		page.accessories(driver).add_product_to_cart(products.Magic_Mouse).click_checkOut();

		// Verify only one Magic Mouse added in the cart
		int expected = page.CheckOut_YourCart(driver).get_item_quantity("Magic Mouse");
		System.out.println(expected);
		Assert.assertEquals(1, expected);
	}

	@Test(dependsOnMethods = { "verify_product_added_in_Cart" })
	public void verify_user_on_Transaction_Result_page() {

		
		// after confirming, click Continue
		page.CheckOut_YourCart(driver).click_checkout_continue();

		// fill out the checkout form
		JSONObject jobject = Utility.readJson("/com/demoqa/store/test/checkout.json");
		page.CheckOut_Info(driver).edit_checkout_form(jobject);

		// Verify user is on Transaction Result page
		boolean isOnResultPage = page.CheckOut_Result(driver).isAt();
		Assert.assertTrue(isOnResultPage, "User is NOT on Transaction Result page");

	}

	@Test(dependsOnMethods = { "verify_user_on_Transaction_Result_page" })
	public void verify_order_is_correct() {
		
		// Verify user has correct order
		String[] actual_result = page.CheckOut_Result(driver).getResultArray();

		String[] expected_result = { "Magic Mouse", "$150.00", "1", "$150.00" };

		Assert.assertEquals(actual_result, expected_result);
	}

}
