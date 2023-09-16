package TestSenarios;

import ObjectPages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommentsAppTest {

    public WebDriver driver;
    public int CommentCount;

    HomePage HPage;

    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qacommentsapp.ccbp.tech/");
        HPage = new HomePage(driver);
        CommentCount =0;
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    //Dataset
    //Name	Comment
    //John	Innovative and interconnected systems.
    //Alice	Smart factories, improved efficiency.
    //Robert	AI-powered automation, limitless potential.
    //Harry	Data-driven decision-making, game-changer.
    //Bob	IoT revolutionizing daily life.

    public Object[][] dataSet={
        {"John","Innovative and interconnected systems."},
        {"Alice","Smart factories, improved efficiency."},
        {"Robert","AI-powered automation, limitless potential."},
        {"Harry","Data-driven decision-making, game-changer."},
        {"Bob","IoT revolutionizing daily life."}
    };

    @DataProvider(name = "DataSetOfNameAndComment")
    public Object[][] DataSet(){
            return dataSet;

    }

    public void addCommentsData() {
        for (Object[] data : dataSet) {
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            HPage.AddSpecifiedNameAndComment(name, comment);
            CommentCount++;
        }
    }


    //Test the Comments App UI
    @Test(priority = 1)
    public void CommentsAppUI(){
        //Navigate to the URL https://qacommentsapp.ccbp.tech/
        //Verify if the App image is displayed - use Assertions,
        //If the App image is not displayed, print "App image is not displayed"
        Assert.assertTrue(HPage.FindAppImage().isDisplayed(),"App image is not displayed");

        //Verify the Heading text of the app - use Assertions
        //Expected text: Comments
        //If the Heading text does not match the expected text, print "Heading text does not match"

        Assert.assertEquals(HPage.GetTextAppHeading(),"Comments","Heading text does not match");

        //Verify the Description text of the app - use Assertions
        //Expected text: Say something about 4.0 Technologies
        //If the Description text does not match the expected text, print "Description text does not match"

        Assert.assertEquals(HPage.GetTextAppDescription(),"Say something about 4.0 Technologies","Description text does not match");

        //Verify the Comments count text of the app - use Assertions
        //Expected text: 0Comments
        //If the Comments count text does not match the expected text, print "Comments count text does not match"
        //Close the browser window.

        Assert.assertEquals(HPage.GetCommentCounterText(),"0Comments","Comments count text does not match");

    }

    //Test the comment counter

    @Test(priority = 2 )
    public void CommentCounter(){
        //Navigate to the URL https://qacommentsapp.ccbp.tech/
        //Add the comments from the dataset table.

        //For each comment added, verify whether the comment count is updated respectively.
        //If the count does not match the expected count, print "Comments count do not match"
        //Close the browser window.
        for(Object[] data : dataSet){
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            HPage.AddSpecifiedNameAndComment(name,comment);
            CommentCount++;

            int ActualCount = HPage.GetCommentCount();
            Assert.assertEquals(ActualCount,CommentCount,"Comments count do not match");
        }


    }

    //Test the comment initials
    @Test(priority = 3,dataProvider = "DataSetOfNameAndComment")
    public void TestCommentInitials(String name,String comment){
        //Navigate to the URL https://qacommentsapp.ccbp.tech/
        //Add the comments from the dataset table individually - use DataProvider.
        //Verify whether the username initials are displayed properly.
        //If the initial does not match the expected initial, print "Initial do not match"
        //Close the browser window.
        HPage.AddSpecifiedNameAndComment(name,comment);

        char initialText = HPage.GetInitialText();

        Assert.assertEquals(initialText,name.charAt(0),"Initial do not match");

    }

    //Test the comment order
    @Test(priority = 4)
    public void TestCommentAndOrder(){
        //Add the comments from the dataset table.
        addCommentsData();
        //Verify whether the username and the comment are displayed in the order they are added.

        for(int i=0 ; i<dataSet.length;i++){
            Object[] data = dataSet[i];
            String name = String.valueOf(data[0]);
            String comment = String.valueOf(data[1]);
            //If the order does not match the expected order, print "Order does not match"
            Assert.assertEquals(HPage.GetUsernameIndex(i),name,"Order does not match");
            //If the comment does not correspond to the username, print "Comment does not correspond to the username"
            //Close the browser window.
            Assert.assertEquals(HPage.GetCommentIndex(i),comment,"Comment does not correspond to the username");

        }

    }

    //Test the likes
    @Test(priority = 5)
    public void TestLike(){
        //Navigate to the URL https://qacommentsapp.ccbp.tech/
        //Add the comments from the dataset table.
        addCommentsData();

        //For each like button clicked, verify whether the total comments liked are as expected
        //If the liked count does not match the expected count, print "Likes count do not match"
        //Close the browser window.
        int LikesCount = 0;

        for(int i=0;i<dataSet.length;i++){
            HPage.clickLikeButtonAt(i);
            LikesCount++;

            Assert.assertEquals(HPage.getLikedCommentsCount(), LikesCount, "Likes count do not match");
        }

    }

    //Test delete functionality

    @Test(priority = 6)
    public void TestDeleteFunctionality(){
        //Navigate to the URL https://qacommentsapp.ccbp.tech/
        //Add the comments from the dataset table.
        addCommentsData();

        // //For each comment deleted, verify whether the total comments count is as expected
        //    //If the comment count does not match the expected count, print "Comments count do not match"
        //    //Close the browser window.
        for(int i=0;i<dataSet.length;i++){
            HPage.ClickOnFirstDeleteButton();

            CommentCount--;
            int actualCount = HPage.GetCommentCount();
            Assert.assertEquals(actualCount, CommentCount,"Comments count do not match");

        }


    }





}
