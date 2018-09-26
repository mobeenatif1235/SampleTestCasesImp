import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
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

WebUI.openBrowser('')
WebUI.navigateToUrl("https://app.convo.com/app/login/?redirect=https%3A%2F%2Fapp.convo.com%2F")
WebUI.maximizeWindow()

String text= WebUI.getUrl().substring(0,5)

assert text=="https"

//locating email address
WebUI.sendKeys(findTestObject('Object Repository/Login Objects/Email Address'), "mobeen.atif@convo.com")
WebUI.sendKeys(findTestObject('Object Repository/Login Objects/Password'), "Kabul@123")

WebUI.click(findTestObject('Object Repository/Login Objects/Loginbutton'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Public and Private groups/Private group array'), 40)
WebUI.waitForElementVisible(findTestObject('Object Repository/Public and Private groups/Public group array'), 40)

WebUI.delay(20)
WebDriver driver=DriverFactory.getWebDriver()

Privategrpscount= driver.findElements(By.xpath("//li[contains(@bo-repeat,'group in privateGroupsArray')]")).size()
println "Private Groups count is: " + Privategrpscount

Publicgrpscount=driver.findElements(By.xpath("//li[contains(@bo-repeat,'group in publicGroupsArray')]")).size()
println "Public Groups count is: " + Publicgrpscount


WebUI.closeBrowser()


