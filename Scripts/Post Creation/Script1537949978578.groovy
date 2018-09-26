import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Timestamp

import org.openqa.selenium.Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.media.controls.ActionControl
import java.sql.Timestamp

WebUI.openBrowser('')
WebUI.navigateToUrl("https://app.convo.com/app/login/?redirect=https%3A%2F%2Fapp.convo.com%2F")
WebUI.maximizeWindow()

String text= WebUI.getUrl().substring(0,5)

assert text=="https"

//locating email address
WebUI.sendKeys(findTestObject('Object Repository/Login Objects/Email Address'), "mobeen.atif@convo.com")
WebUI.sendKeys(findTestObject('Object Repository/Login Objects/Password'), "Kabul@123")
//clicking on login button
WebUI.click(findTestObject('Object Repository/Login Objects/Loginbutton'))

WebUI.waitForAngularLoad(100)

                                // New Post creation


WebUI.waitForElementVisible(findTestObject('Object Repository/Post Creation/Post field'),40, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Post Creation/Post field'))

WebUI.delay(20)

String timestamp=getTimeStamp()

println "Generated timestamp right now is: " + timestamp

WebUI.waitForElementVisible(findTestObject('Object Repository/Post Creation/Title field'), 30)

WebUI.sendKeys(findTestObject('Object Repository/Post Creation/Title field'), timestamp+"This is Test Title")

WebUI.waitForElementVisible(findTestObject('Object Repository/Post Creation/post editor'), 30)

WebUI.sendKeys(findTestObject('Object Repository/Post Creation/post editor'), timestamp+"This is Test Post")


WebUI.waitForElementVisible(findTestObject('Object Repository/Post Creation/Share button'), 30)

WebUI.click(findTestObject('Object Repository/Post Creation/Share button'))


public String getTimeStamp(){
	
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String timeStampInNumberFormat = timestamp.getTime()
			return timeStampInNumberFormat;
		}

WebUI.delay(20)


// Creating the Test Object to locate the created post. (),Post Indexing

TestObject newPostCreated = new TestObject('new post created')
String xpathNewPostCreated = '//span/p[contains(text(), "' + timestamp + '")]'

newPostCreated.addProperty('xpath', ConditionType.EQUALS, xpathNewPostCreated, true)

//Wait for test post created to be visible.
WebUI.waitForElementVisible(newPostCreated, 60)

//To verify new post created is present.
WebUI.verifyElementPresent(newPostCreated, 30)


WebUI.delay(20)

TestObject newPostCreated2 = new TestObject('newly post created')
String xpathPostSharedTitleText = "//div/a[contains(text(),'" + timestamp + "')]"
newPostCreated2.addProperty('xpath', ConditionType.EQUALS, xpathPostSharedTitleText, true)

WebUI.waitForElementVisible(newPostCreated2, 60)

//To verify new post created is present.
WebUI.verifyElementPresent(newPostCreated2, 30)

WebUI.click(newPostCreated2)


WebUI.delay(30)
WebUI.closeBrowser()
