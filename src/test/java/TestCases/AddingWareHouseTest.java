package TestCases;

import Pages.*;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddingWareHouseTest extends BaseTest {
    Random random;
    int randomNumber;
    String wareHouseName;
    HomePage homePageObj;
    WareHouseListPage wareHouseListPageObj;
    WareHousePage wareHousePageObj;
    @Test(priority = 1, enabled = true)
    public void TC01_createNewWareHouse() throws InterruptedException {
        random = new Random();
        randomNumber = random.nextInt(1000000000);
        wareHouseName = "wareHouse " + randomNumber;
        homePageObj = new HomePage(driver);
        wareHouseListPageObj = homePageObj.openWareHouseListPage();
        String numberOfAllWareHousesBeforeCreatingNewOne = wareHouseListPageObj.getNumberOfAllWareHouseBeforeCreatingNewWareHouse();

        wareHousePageObj = wareHouseListPageObj.clickOnNewWareHouseBtn();
        wareHousePageObj.enterValidDataIntoWareHousePage(wareHouseName);
        Assert.assertTrue(wareHousePageObj.getWareHouseName(wareHouseName).contains(wareHouseName));
        Allure.step("Verify the name of current created item is existed at item list view ");
        wareHouseListPageObj = wareHousePageObj.openWareHouseListPage();
        Assert.assertTrue(wareHouseListPageObj.getWareHouseNameAtViewList(wareHouseName).contains(wareHouseName));
        String numberOfWareHousesAfterCreatingNewOne = wareHouseListPageObj.getNumberOfAllWareHousesAfterCreatingNewWareHouse();
        Allure.step("verify that number of all warehouse at list view will increase by one after creating new warehouse");
        Assert.assertFalse(numberOfAllWareHousesBeforeCreatingNewOne.contains(numberOfWareHousesAfterCreatingNewOne));
        Allure.step(" number of all warehouses at list view before creating new one is " + numberOfAllWareHousesBeforeCreatingNewOne + " and after creating new one is  " + numberOfWareHousesAfterCreatingNewOne + " and this is correct ");
    }

}
