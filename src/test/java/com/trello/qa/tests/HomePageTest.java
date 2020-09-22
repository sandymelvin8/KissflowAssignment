package com.trello.qa.tests;

import com.trello.qa.base.testbase;
import com.trello.qa.pages.HomePage;
import com.trello.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends testbase {

    LoginPage loginPage;
    HomePage homePage;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.validLogin(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void createNewBoardsTest() throws InterruptedException {
        try {
            homePage.createNewBoard();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
