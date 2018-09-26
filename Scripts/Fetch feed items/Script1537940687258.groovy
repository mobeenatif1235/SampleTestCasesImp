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
//clicking on login button
WebUI.click(findTestObject('Object Repository/Login Objects/Loginbutton'))

WebUI.waitForAngularLoad(100)

//locatiing the feed items

WebDriver driver=DriverFactory.getWebDriver()
feedcount=driver.findElements(By.xpath("//cnv-feed-item")).size()
println "This is feed items count without the scroll" + feedcount

WebUI.delay(20)
int i=0;

while (i<50)
{
	Actions actions=new Actions(driver)
	actions.moveToElement(driver.findElement(By.xpath("//div[@id='feedScroller']")))
	
	actions.sendKeys(Keys.ARROW_DOWN);
	actions.build().perform();
	i=i+1
}
WebUI.delay(20)
feedcount2=driver.findElements(By.xpath("//cnv-feed-item")).size()

println "This is feed items count with the scroll" + feedcount2


WebUI.closeBrowser()
