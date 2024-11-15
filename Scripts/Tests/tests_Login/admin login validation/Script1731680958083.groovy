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

// ===== populate the invalid credentials =====
WebUI.waitForElementPresent(findTestObject('pages_login/lgn_inputUsername'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_login/lgn_inputPassword'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_login/lgn_btn_login'), GlobalVariable.delayShort)

WebUI.setText(findTestObject('pages_login/lgn_inputUsername'), GlobalVariable.username_Admin)

WebUI.setText(findTestObject('pages_login/lgn_inputPassword'), GlobalVariable.passwrod_Admin)

WebUI.click(findTestObject('pages_login/lgn_btn_login'), FailureHandling.STOP_ON_FAILURE)

// ===== Assert - Error message "Invalid Credentials" =====
WebUI.waitForElementPresent(findTestObject('pages_login/lgn_validationMessageInvalidCredentials'), GlobalVariable.delayShort)

WebUI.verifyElementText(findTestObject('pages_login/lgn_validationMessageInvalidCredentials'), GlobalVariable.errorMessage_invalidCredentials)

WebUI.takeFullPageScreenshot()

// ===== Clear Text =====
WebUI.clearText(findTestObject('pages_login/lgn_inputUsername'))

WebUI.clearText(findTestObject('pages_login/lgn_inputPassword'))

WebUI.click(findTestObject('pages_login/lgn_btn_login'), FailureHandling.STOP_ON_FAILURE)

// ===== Assert - Error message for Mandatory Field Validation =====
WebUI.waitForElementPresent(findTestObject('pages_login/lgn_validationMessageUsernameMandatory'), GlobalVariable.delayShort, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('pages_login/lgn_validationMessagePasswordMandatory'), GlobalVariable.delayShort, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.takeFullPageScreenshot()

WebUI.closeBrowser()

