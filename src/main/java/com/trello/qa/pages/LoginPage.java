package com.trello.qa.pages;

import com.trello.qa.base.testbase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends testbase {

//  Page factory or Object repo
    @FindBy(id = "user")
    WebElement username;

    @FindBy(id = "login")
    WebElement loginwithAtlassian;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//div[@id='password-error']//p[@class='error-message']")
    WebElement errorMessage;

    @FindBy(xpath = "//button[@id='login-submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='login']")
    WebElement submitBtn;

    @FindBy(xpath = "//img[contains(@class,'trello-main-logo')]")
    WebElement logo;

//  To initialize the Page Factory and this keyword to initialize current last object(Object Repo)
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateTrelloLogo(){
        return logo.isDisplayed();
    }

    public void invalidLogin(String invuser, String invpwd) throws InterruptedException {
        username.sendKeys(invuser);
        Thread.sleep(1000);
        password.sendKeys(invpwd);
        submitBtn.click();
    }

    public HomePage validLogin(String un, String pwd) throws InterruptedException {
        username.clear();
        username.sendKeys(un);
        Thread.sleep(2000);
        loginwithAtlassian.click();
        password.clear();
        password.sendKeys(pwd);
        Thread.sleep(2000);
        loginBtn.click();
        return new HomePage();
    }
}
