package com.trello.qa.tests;

import com.trello.qa.base.testbase;
import com.trello.qa.pages.BoardsPage;
import com.trello.qa.pages.HomePage;
import com.trello.qa.pages.LoginPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardsPageTest extends testbase {

    LoginPage loginPage;
    HomePage homePage;
    BoardsPage boardsPage;

    public BoardsPageTest(){
        super();
    }

    @BeforeSuite
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.validLogin(prop.getProperty("username"),prop.getProperty("password"));
        boardsPage= new BoardsPage();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void createBoardTest() {
        try {
            boardsPage.searchBoard();
        } catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void notStartedTest() {
        try {
            boardsPage.createNotStarted();
        } catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void inProgressTest(){
        try {
            boardsPage.createInProgress();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 4)
    public void inQATest() {
        try {
            boardsPage.createQA();
        } catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }

    }

    @Test(priority = 5)
    public void doneTest() {
        try {
            boardsPage.createDone();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 6)
    public void addcardsTest() {
        try {
            boardsPage.addCards();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 7)
    public void moveCard2toInprogressTest() {
        try {
            boardsPage.moveCard2toInprogress();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 8)
    public void moveCard3toQATest() {
        try {
            boardsPage.moveCard3toQA();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 9)
    public void moveCard2toQATest() {
        try {
            boardsPage.moveCard2toQA();
        }
        catch(Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @Test(priority = 10)
    public void assignCard1toCurrentUserTest(){
        try{
            boardsPage.assignCard1toCurrentUser(prop.getProperty("name"));
        }
        catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
