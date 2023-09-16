package ObjectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    //Define the locators for the Home page using Page Factory
    //App image

    @FindBy(className = "image")
            @CacheLookup
    WebElement AppImageLocator;


    //App heading
    @FindBy(className = "app-heading")
            @CacheLookup
    WebElement AppHeadingLocator;

    //App description
    @FindBy(className = "form-description")
    @CacheLookup
    WebElement AppDescriptionLocator;

    //Name input field
    @FindBy(className = "name-input")
    @CacheLookup
    WebElement NameInputLocator;

    //Comment input field
    @FindBy(className = "comment-input")
    @CacheLookup
    WebElement CommentInputLocator;

    //"Add Comment" button
    @FindBy(className = "add-button")
    @CacheLookup
    WebElement AddCommentButtonLocator;

    //Comment counter text

    @FindBy(className = "heading")
    @CacheLookup
    WebElement CommentCounterTextLocator;

    //Comment counter element(
    //)

    @FindBy(className = "comments-count")
    @CacheLookup
    WebElement CommentCounterElementLocator;

    //Initial text
    @FindBy(className = "initial-container")
    @CacheLookup
    WebElement InitialTextLocator;

    //Comment username text
    @FindBy(className = "username")
    @CacheLookup
    List<WebElement> CommentUserNameLocator;

    //Comment text

    @FindBy (className = "comment")
    @CacheLookup
    List<WebElement>  CommentTextLocator;

    //List of like buttons

    @FindBy(xpath = "//button[text() = 'Like']")
    List<WebElement> likeButtonElements;


    //List of liked comments
    @FindBy(className = "active")
    List<WebElement> likedCommentElements;
    //List of delete buttons

    @FindBy(xpath = "//img[@class = 'delete']/parent::button")
    List<WebElement> deleteButtonElements;


    //----------------------------------------------------------------------------------------------

    WebDriver driver;
    WebDriverWait wait;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Define the methods for performing actions on the elements
    //Find the app image

    public WebElement FindAppImage(){
        return AppImageLocator;
    }

    //Get the text content of the app heading

    public String GetTextAppHeading(){
        return AppHeadingLocator.getText();
    }
    //Get the text content of the app description

    public String GetTextAppDescription(){
        return AppDescriptionLocator.getText();
    }

    //Enter a text in the name input field

    public void EnterNameInputField(String name){
         NameInputLocator.sendKeys(name);
    }

    //Enter a text in the comment input field

    public void EnterCommentInputField(String comment){
        CommentInputLocator.sendKeys(comment);
    }

    //Click the "Add Comment" button
    public void ClickOnAddButton(){
        AddCommentButtonLocator.click();
    }

    //Add a comment with a specified name and comment
    public void AddSpecifiedNameAndComment(String name,String comment){
        EnterNameInputField(name);
        EnterCommentInputField(comment);
        ClickOnAddButton();
    }


    //Get the text content of the comment counter text
    public String GetCommentCounterText(){
        return CommentCounterTextLocator.getText();
    }

    //Get the comment count
    public int GetCommentCount(){
        return  Integer.parseInt(CommentCounterElementLocator.getText());
    }

    //Get the text content of the initial text
    public char GetInitialText(){
        return InitialTextLocator.getText().charAt(0);
    }

    //Get the username text at a specified index
    public String GetUsernameIndex(int index){
        return CommentUserNameLocator.get(index).getText();
    }
    //Get the comment text at a specified index
    public String GetCommentIndex(int index){
        return CommentTextLocator.get(index).getText();
    }
    //Click the like button at a specified index

    public void clickLikeButtonAt(int index) {
        likeButtonElements.get(index).click();
    }

    //Get the count of the liked comments

    public int getLikedCommentsCount() {
        return likedCommentElements.size();
    }
    //Click the first delete button

    public void ClickOnFirstDeleteButton(){
         deleteButtonElements.get(0).click();
    }
}
