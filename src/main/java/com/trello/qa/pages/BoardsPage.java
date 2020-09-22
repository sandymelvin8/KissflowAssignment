package com.trello.qa.pages;

import com.trello.qa.base.testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoardsPage extends testbase {

    @FindBy(xpath = "//span[@class='MEu8ZECLGMLeab']")
    WebElement boardsBtn;

    @FindBy(xpath = "//input[@name='search-boards']")
    WebElement searchText;

    @FindBy(xpath = "//span[contains(text(),'Add a list')]")
    WebElement addList;

    @FindBy(xpath = "//input[@name='name']")
    WebElement listName;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement addListBtn;

    @FindBy(xpath = "//span[contains(text(),'Add a card')]")
    WebElement addcard1Name;

    @FindBy(xpath = "//textarea[@placeholder='Enter a title for this card…']")
    WebElement textarea;
    //  To initialize the Page Factory and this keyword to initialize current last object(Object Repo)
    public BoardsPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBoard() throws InterruptedException{
        Thread.sleep(10000);
        boardsBtn.click();
        searchText.sendKeys(prop.getProperty("boardname"));
        searchText.sendKeys(Keys.ENTER);
    }

    public void createNotStarted()throws InterruptedException{
        addList.click();
        listName.clear();
        listName.sendKeys(prop.getProperty("list1"));
        Thread.sleep(1000);
        addListBtn.click();
    }

    public void createInProgress() throws InterruptedException {
        Thread.sleep(2000);
        listName.clear();
        listName.sendKeys(prop.getProperty("list2"));
        Thread.sleep(1000);
        addListBtn.click();
    }

    public void createQA() throws InterruptedException{
        Thread.sleep(2000);
        listName.sendKeys(prop.getProperty("list3"));
        Thread.sleep(1000);
        addListBtn.click();
    }

    public void createDone() throws InterruptedException{
        Thread.sleep(2000);
        listName.sendKeys(prop.getProperty("list4"));
        Thread.sleep(1000);
        addListBtn.click();
    }

    public void addCards(){
        try {
                addcard1Name.click();
                textarea.sendKeys("card 1",Keys.ENTER);
                Thread.sleep(2000);
                textarea.sendKeys("card 2",Keys.ENTER);
                Thread.sleep(2000);
                textarea.sendKeys("card 3",Keys.ENTER);
                Thread.sleep(2000);
                textarea.sendKeys("card 4",Keys.ENTER);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//div[@id='trello-root']")).click();

        } catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void moveCard2toInprogress() throws InterruptedException {
        WebElement source= driver.findElement(By.xpath("//span[contains(text(),'card 2')]"));
        Thread.sleep(2000);
        WebElement target= driver.findElement(By.xpath("//textarea[contains(text(),'In progress')]"));
        new Actions(driver).dragAndDrop(source,target).perform();
    }

    public void moveCard3toQA() throws InterruptedException {
        WebElement source= driver.findElement(By.xpath("//span[contains(text(),'card 3')]"));
        Thread.sleep(2000);
        WebElement target=driver.findElement(By.xpath("//textarea[contains(text(),'QA')]"));
        new Actions(driver).dragAndDrop(source,target).perform();
    }

    public void moveCard2toQA() throws InterruptedException {
        WebElement source= driver.findElement(By.xpath("//span[contains(text(),'card 2')]"));
        Thread.sleep(2000);
        WebElement target= driver.findElement(By.xpath("//textarea[contains(text(),'QA')]"));
        new Actions(driver).dragAndDrop(source,target).perform();

    }

    public void assignCard1toCurrentUser(String name) throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'card 1')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='window-sidebar']//span[contains(text(),'Members')]")).click();
        Thread.sleep(2000);
        WebElement user= driver.findElement(By.xpath("//span[@class='full-name' and contains(text(),'"+name+"')]"));
        Actions action=new Actions(driver);
        action.moveToElement(user).click(user).build().perform();
        Thread.sleep(2000);
        WebElement comment=driver.findElement(By.xpath("//form//div[@class='comment-box']"));
        comment.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@placeholder='Write a comment…']")).sendKeys("I am Done");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='comment-controls u-clearfix']" +
                "//input[@value='Save']")).click();
        WebElement closebutton= driver.findElement(By.xpath("//a[@class='icon-md icon-close " +
                "dialog-close-button js-close-window']"));
        closebutton.click();
    }
}
