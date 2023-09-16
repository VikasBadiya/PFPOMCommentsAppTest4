In this exercise, you will be automating the process of testing the Comments App using Page Object Model.

### Prerequisites

- Install IntelliJ IDEA Community IDE  Version 2018.3.6.
- Install OpenJDK 11 and complete the configuration.
- Install a Browser Driver(Chrome Driver).
- Setup a Selenium project with the name `CommentsAppTest4`.
- Update the Build in `pom.xml`. Refer to previous exercises for reference.

You can refer to this [Reading Material](https://learning.ccbp.in/qa-automation-testing/course?c_id=cf952b35-27ab-4b1e-a6de-44227f22806c&s_id=f5c19277-3889-4e63-b631-c06c088d612c&t_id=6a935df7-2c93-477c-b505-3ae0aabcf9a2#31-installing-ide) to complete the above prerequisites.

### Dataset

|  Name  |                   Comment                   |
| :----: | :-----------------------------------------: |
|  John  |   Innovative and interconnected systems.    |
| Alice  |    Smart factories, improved efficiency.    |
| Robert | AI-powered automation, limitless potential. |
| Harry  | Data-driven decision-making, game-changer.  |
|  Bob   |       IoT revolutionizing daily life.       |

**Application URL**: `https://qacommentsapp.ccbp.tech/`

### Test Instructions

- Create a new package `pages` in the `src/test/java` directory.
- Create a `HomePage` class in the `pages` package.
    
    
    <details>
    <summary>Define the locators for the Home page _using Page Factory_</summary>
    >  - App image
    >  - App heading
    >  - App description
    >  - Name input field
    >  - Comment input field
    >  - "Add Comment" button
    >  - Comment counter text
    >  - Comment counter element(<span>)
    >  - Initial text
    >  - Comment username text
    >  - Comment text
    >  - List of like buttons
    >  - List of liked comments
    >  - List of delete buttons
    </details>
    <details>
    <summary>Define the methods for performing actions on the elements</summary>
    >  - Find the app image
    >  - Get the text content of the app heading
    >  - Get the text content of the app description
    >  - Enter a text in the name input field
    >  - Enter a text in the comment input field
    >  - Click the "Add Comment" button
    >  - Add a comment with a specified name and comment
    >  - Get the text content of the comment counter text
    >  - Get the comment count
    >  - Get the text content of the initial text
    >  - Get the username text at a specified index
    >  - Get the comment text at a specified index
    >  - Click the like button at a specified index
    >  - Get the count of the liked comments
    >  - Click the first delete button
    </details>
- Create a `CommentsAppTest` class and write the test cases for the below test scenarios,

    _Note: The test cases should be executed in the same order as given below_

    <details>
    <summary>Test the Comments App UI</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Verify if the App image is displayed - _use Assertions_,
    >    - If the App image is not displayed, print "App image is not displayed"
    >- Verify the Heading text of the app - _use Assertions_
    >    - Expected text: `Comments`
    >    - If the Heading text does not match the expected text, print "Heading text does not match" 
    >- Verify the Description text of the app - _use Assertions_
    >    - Expected text: `Say something about 4.0 Technologies`
    >    - If the Description text does not match the expected text, print "Description text does not match" 
    >- Verify the Comments count text of the app - _use Assertions_
    >    - Expected text: `0Comments`
    >    - If the Comments count text does not match the expected text, print "Comments count text does not match" 
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the comment counter</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Add the comments from the dataset table.
    >- For each comment added, verify whether the comment count is updated respectively.
    >    - If the count does not match the expected count, print "Comments count do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the comment initials</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Add the comments from the dataset table individually - _use DataProvider_.
    >- Verify whether the username initials are displayed properly.
    >    - If the initial does not match the expected initial, print "Initial do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the comment order</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Add the comments from the dataset table.
    >- Verify whether the username and the comment are displayed in the order they are added.
    >    - If the order does not match the expected order, print "Order does not match"
    >    - If the comment does not correspond to the username, print "Comment does not correspond to the username"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test the likes</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Add the comments from the dataset table.
    >- For each like button clicked, verify whether the total comments liked are as expected 
    >    - If the liked count does not match the expected count, print "Likes count do not match"
    >- Close the browser window.
    </details>
    <details>
    <summary>Test delete functionality</summary>
    >- Navigate to the URL `https://qacommentsapp.ccbp.tech/`
    >- Add the comments from the dataset table.
    >- For each comment deleted, verify whether the total comments count is as expected 
    >    - If the comment count does not match the expected count, print "Comments count do not match"
    >- Close the browser window.
    </details>

### Running Tests

- Use Parallel testing with _parallel_ attribute values as **classes** and _thread-count_ required for the tests to run parallel.

<br>
<br>

**Note: Set up the project and practice this exercise in your local IDE(IntelliJ).**