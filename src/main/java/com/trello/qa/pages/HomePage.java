package com.trello.qa.pages;

import com.trello.qa.base.testbase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends testbase {

    @FindBy(xpath = "//span[@class='MEu8ZECLGMLeab']")
    WebElement boardsBtn;

    @FindBy(xpath = "//button[contains(text(),'Create new board…')]")
    WebElement newBoardBtn;

    @FindBy(xpath = "//input[@placeholder='Add board title']")
    WebElement addBoardTitle;

    @FindBy(xpath = "//button[contains(text(),'Create Board')]")
    WebElement createBoardBtn;

//  To initialize the Page Factory and this keyword to initialize current last object(Object Repo)
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

//  Actions to perform

    public BoardsPage createNewBoard() throws InterruptedException {
        boardsBtn.click();
        Thread.sleep(2000);
        newBoardBtn.click();
        Thread.sleep(2000);
        addBoardTitle.sendKeys(prop.getProperty("boardname"));
        Thread.sleep(2000);
        addBoardTitle.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        return new BoardsPage();
    }
}
