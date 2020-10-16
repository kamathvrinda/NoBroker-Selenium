package com.nobroker.testcases;

import com.nobroker.pages.BaseClass;
import com.nobroker.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class GetPropertyList extends BaseClass {
    @Test
    public void selectRequiredProductType() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		homePage.selectProductType("Buy");
		homePage.selectDropDown();
        homePage.selectFromPlace("Mumbai");
		homePage.searchClickBtn();

        Thread.sleep(4000);



    }
}
