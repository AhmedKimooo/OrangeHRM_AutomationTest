package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeManagementPage {

    protected WebDriver driver;

    public EmployeeManagementPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }
    /*************************************************** attribute of Employee Management Page********/
    @FindBy (xpath = ("//div[@ng-if='!ohrmnavbar.isClickableTitle($index)']"))
    private WebElement pageTitle;

    @FindBy(partialLinkText = "Employee Li")
    private WebElement employeeList;

    @FindBy(xpath = ("//i[normalize-space()='add']"))
    private WebElement addEmployeeBtn;


   /********************************************** function on Employee Management Page *******/
    public boolean getPageTitle(){
        return pageTitle.isDisplayed();
    }

    public EmployeeManagementPage EmployeeListPage(){
        employeeList.click();
        return this;
    }
    public EmployeeManagementPage addEmployeeBtn(){
        addEmployeeBtn.click();
        return this;
    }
    /**************************************** Attribute of add subPage ************************************/

    @FindBy(className = "modal-title")
    WebElement addSubPageTitle;

    @FindBy(id = "first-name-box")
    WebElement firstName;

    @FindBy(id="middle-name-box")
    WebElement middleName;

    @FindBy(id = "last-name-box")
    WebElement lastName;

    @FindBy(id = "modal-save-button")
    WebElement saveBtn;
    /**************************************** function to add new employee *********************/
    public EmployeeManagementPage setAddEmployee(String firstName, String middleName , String lastName){
        this.firstName.sendKeys(firstName);
        this.middleName.sendKeys(middleName);
        this.lastName.sendKeys(lastName);
        this.saveBtn.click();
        return this;

    }















}
