package com.trello.qa.tests;

import com.trello.qa.base.testbase;
import com.trello.qa.pages.HomePage;
import com.trello.qa.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends testbase {

    LoginPage loginPage;
    HomePage homePage;

//  To call the super class constructor(testbase)
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void invalidLoginTest() {
        try {
            loginPage.invalidLogin(prop.getProperty("invaliduser"), prop.getProperty("invalidpwd"));
            WebElement actual_msg = driver.findElement(By.xpath("//div[@id='password-error']//p[contains(text(),'Incorrect email address and ')]"));
            String str = actual_msg.getText();
            if (str.contains("Incorrect email")) {
                System.out.println("Invalid login");
                Thread.sleep(3000);
            }
            String title = loginPage.validateLoginPageTitle();
            Assert.assertEquals(title, "Log in to Trello", "Title does not match");
            Thread.sleep(2000);
            boolean logocheck = loginPage.validateTrelloLogo();
            Assert.assertTrue(logocheck, "Logo does not match");
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void loginTest() {
        try {
            homePage = loginPage.validLogin(prop.getProperty("username"), prop.getProperty("password"));
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
