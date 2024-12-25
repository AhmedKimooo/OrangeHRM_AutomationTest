package com.OrangeHRM.Testcases;
import com.OrangeHRM.Base.BaseTests;
import com.OrangeHRM.Pages.Buzz;
import com.OrangeHRM.Pages.EmployeeManagementPage;
import com.OrangeHRM.Pages.LoginPage;
import groovy.xml.StreamingDOMBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Tests extends BaseTests {


    @Test
    public void login (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Admin")
                .setPassword("admin123")
                .loginBtn();
        Assert.assertTrue(loginPage.theErrorMSg());


    }
    @Test
    public void invalidLoginUser(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("addmin")
                .setPassword("admin123")
                .loginBtn();
        Assert.assertTrue(loginPage.theErrorMSg());
    }

    @Test
    public void invalidLoginPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Admin")
                .setPassword("123")
                .loginBtn();
        Assert.assertTrue(loginPage.theErrorMSg());

    }

    @Test
    public void EmployeeManagement() throws InterruptedException {

        //Section I
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Admin")
                .setPassword("admin123")
                .loginBtn();
        //Section II
        EmployeeManagementPage employeeManagementPage = new EmployeeManagementPage(driver);

        employeeManagementPage.getPageTitle();
        employeeManagementPage.EmployeeListPage();
        Thread.sleep(5000);
        employeeManagementPage
                .addEmployeeBtn()
                .setAddEmployee("ahmed","kamal","mohamed");

    }



    @Test
    public void checkBuzzPage() throws InterruptedException {
        //Section I
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Admin")
                .setPassword("admin123")
                .loginBtn();

        //Buzz Section
        Thread.sleep(3000);
        Buzz buzz = new Buzz(driver);
        buzz.goBuzz()
                .sleep()
                .switchPage()
                .addPost("hello world")
                .sleep();

    }

    @Test
    public void deletePost() throws InterruptedException {
        //Section I
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setUserName("Admin")
                .setPassword("admin123")
                .loginBtn();

        //Buzz Section
        Thread.sleep(3000);
        Buzz buzz = new Buzz(driver);
        buzz.goBuzz()
                .sleep()
                .switchPage().sleep().deletePosts();

    }















}
