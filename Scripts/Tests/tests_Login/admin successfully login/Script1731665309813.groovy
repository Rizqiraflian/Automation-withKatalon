import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


// ===== Call Test Cas - Navigate to login page =====
WebUI.callTestCase(findTestCase('Module/call_navigation/_call_accessLoginPage'), [:], FailureHandling.STOP_ON_FAILURE)

// ===== populate the valid credentials =====
WebUI.waitForElementPresent(findTestObject('pages_login/lgn_inputUsername'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_login/lgn_inputPassword'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_login/lgn_btn_login'), GlobalVariable.delayShort)

WebUI.setEncryptedText(findTestObject('pages_login/lgn_inputUsername'), GlobalVariable.username_Admin)

WebUI.setEncryptedText(findTestObject('pages_login/lgn_inputPassword'), GlobalVariable.passwrod_Admin)

WebUI.click(findTestObject('pages_login/lgn_btn_login'), FailureHandling.STOP_ON_FAILURE)

// ===== Assert - Verify it's redirect to the correct dashboard page URL =====
while (GlobalVariable.initialNumber < 10) {
    if (GlobalVariable.initialNumber < 9) {
        if (!(WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.mainUrl) + GlobalVariable.dashboardUrl, true, 
            FailureHandling.OPTIONAL))) {
            WebUI.delay(GlobalVariable.delayLong)

            (GlobalVariable.initialNumber)++
        } else {
            break
        }
    } else {
        WebUI.verifyMatch(WebUI.getUrl(), ('https://' + GlobalVariable.mainUrl) + GlobalVariable.dashboardUrl, true, FailureHandling.STOP_ON_FAILURE)
    }
}

WebUI.closeBrowser()

