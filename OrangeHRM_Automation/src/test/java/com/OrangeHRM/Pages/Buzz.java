package com.OrangeHRM.Pages;

import com.github.dockerjava.api.model.UpdateOrder;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Buzz {

    public WebDriver driver;

    public Buzz(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(css = "[class=\"top-level-menu-item \"]")
    private WebElement buzz;

    @FindBy(xpath = ("//textarea[@placeholder=\"What's on your mind?\"]") )
    private WebElement postPlaceHolder;

    @FindBy(xpath = ("//button[@class='oxd-button oxd-button--medium oxd-button--main postButton']"))
    private WebElement postBtn;


    @FindBy(css = ("[data-test=\"buzzPostWrapper\"]"))
    List<WebElement> postBox;

    @FindBy(css = "[data-test=\"likeButton\"]")
    WebElement likes ;

    @FindBy(css = ("[data-test=\"commentButton\"]"))
    WebElement commentBtn;

    @FindBy(xpath = ("//div[@class='buzz-container']//div[1]//div[1]//div[5]//div[2]//div[1]//form[1]//div[1]//div[1]//div[2]//div[1]//input[1]"))
    WebElement postComment;
/***************************************************Delete Post*****************************************/
    @FindBy(css = "[class=\"oxd-icon-button\"]")
    WebElement deletePostBtn;
    @FindBy(css = "[class=\"oxd-userdropdown-link\"]")
    WebElement deletePostIcon;
/************************************************************/
    @FindBy(css = "[data-test=\"nonEditCommentContent\"]")
    List<WebElement> subPostBox;

    @FindBy(css = "[data-test=\"likeOnCommentDiv\"]")
    WebElement likeComment;

    @FindBy(css = "[data-test=\"editComment\"]")
    WebElement editComment;

    @FindBy(css = "[data-test=\"deleteComment\"]")
    WebElement deleteComment;

    @FindBy(css = "[data-test=\"deleteButton\"]")
    WebElement ensureDeletePost;

    @FindBy(xpath = ("(//input[@placeholder='Write your comment...'])[2]"))
    WebElement editedComment;


    /************************************************** functions ****************************/
    public Buzz goBuzz(){
        buzz.click();

        return this;
    }

    public Buzz sleep() throws InterruptedException {
        Thread.sleep(4000);
        return this;
    };


    /***************************************** switch from Management page to Buzz page ********************/
    public Buzz switchPage(){
        String parent = driver.getWindowHandle();
        System.out.println(parent);
        Set<String> allwindows =driver.getWindowHandles();
        for(String window :allwindows){
            if(!window.equalsIgnoreCase(parent)){
                driver.switchTo().window(window);
            }
        }
        return this;
    };

    public Buzz postBtn(){
        postBtn.click();
        return this;
    };


    /**************** make post --> like post --> make comment --> like comment --> edit comment --> delete comment ****/
    public Buzz addPost(String makePost) throws InterruptedException {
        for (int x = 0; x<2; x++){
            Thread.sleep(2000);
            //Make new Post
            int random =(int) (Math.random() * 1000);
            postPlaceHolder.sendKeys(makePost+random);
            Thread.sleep(2000);
            postBtn.click();
            Thread.sleep(3000);

            //Make like on Posts

            for (WebElement box :postBox){
                if (box.isDisplayed()){
                    //System.out.println("like is here");
                    likes.click();
                    Thread.sleep(3);
                    commentBtn.click();
                    Thread.sleep(1000);
                    postComment.sendKeys("Well Played");
                    Thread.sleep(1000);
                    postComment.sendKeys(Keys.RETURN);
                    break;
                }else{
                    continue;
                }
            }
            for (WebElement box :subPostBox){
                if (box.isDisplayed()){
                    //System.out.println("like is here");
                    likeComment.click();
                    Thread.sleep(2000);
                    editComment.click();
                    Thread.sleep(2000);
                    editedComment.sendKeys(" gonna Deleted");
                    Thread.sleep(2000);
                    editedComment.sendKeys(Keys.RETURN);
                    Thread.sleep(2000);
                    deleteComment.click();
                    Thread.sleep(2000);
                    ensureDeletePost.click();

                    break;
                }else{
                    continue;
                }
            }


        }
        return this;
    };

 /****************************************** Delete Post ************************************************/
    public Buzz deletePosts() throws InterruptedException {
        for (WebElement post :postBox){
            if (post.isDisplayed()){
                deletePostBtn.click();
                Thread.sleep(1000);
                deletePostIcon.click();
                Thread.sleep(1000);
                ensureDeletePost.click();

            }else{
                continue;
            }
        }
        return this;

    }






}
