package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     protected WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

/***************************************************** Login Attribute *********************************/
    @FindBy(xpath = ("//*[@id=\"txtUsername\"]"))
    private WebElement userName;

    @FindBy(name = ("txtPassword"))
    private WebElement password;

    @FindBy(xpath = ("//*[@id=\"frmLogin\"]/div[4]/button"))
    private WebElement loginBtn;

    @FindBy(css = "[class=\"toast-message\"]")
    WebElement errorMSg;
/**************************************************** Functions *****************************************/
    public LoginPage setUserName(String name){
        userName.sendKeys(name);
        return this;
    }

    public LoginPage setPassword(String password){
        this.password.sendKeys(password);
        return this;
    }

    public void loginBtn (){
        loginBtn.click();
    }

    public Boolean theErrorMSg(){
        return errorMSg.isDisplayed();
    }



}
