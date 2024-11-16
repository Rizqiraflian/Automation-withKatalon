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

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_title'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_inputFirstName'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_inputMiddleName'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_inputLastName'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_inputEmployeeId'), GlobalVariable.delayShort)

WebUI.waitForElementPresent(findTestObject('pages_employee/_form_addEmployee/form_sliderCreateLoginDetails'), GlobalVariable.delayShort)

WebUI.callTestCase(findTestCase('Module/call_function/_call_functionForEmployee/_call_empl_generateRandomData'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('pages_employee/_form_addEmployee/form_inputFirstName'), GlobalVariable.empl_dynamicFirstName)

WebUI.setText(findTestObject('pages_employee/_form_addEmployee/form_inputMiddleName'), GlobalVariable.empl_dynamicMiddleName)

WebUI.setText(findTestObject('pages_employee/_form_addEmployee/form_inputLastName'), GlobalVariable.empl_dynamicLastName)

WebUI.click(findTestObject('pages_employee/_form_addEmployee/form_inputEmployeeId'))

int element = WebUI.getAttribute(findTestObject('pages_employee/_form_addEmployee/form_inputEmployeeId'), 'value').length()

// Focus on the field
// Get the text length and send Backspace for each character
for (int i = 0; i < element; i++) {
    WebUI.sendKeys(findTestObject('pages_employee/_form_addEmployee/form_inputEmployeeId'), Keys.chord(Keys.BACK_SPACE))
}

WebUI.setText(findTestObject('pages_employee/_form_addEmployee/form_inputEmployeeId'), GlobalVariable.empl_dynamicEmployeeId)

WebUI.click(findTestObject('pages_employee/_form_addEmployee/form_sliderCreateLoginDetails'))

WebUI.setText(findTestObject('pages_employee/_form_addEmployee/form_inputUsername'), GlobalVariable.empl_dynamicUsername)

WebUI.setEncryptedText(findTestObject('pages_employee/_form_addEmployee/form_inputPassword'), GlobalVariable.universalPassword)

WebUI.setEncryptedText(findTestObject('pages_employee/_form_addEmployee/form_inputConfirmPassword'), GlobalVariable.universalPassword)

GlobalVariable.empl_dynamicPersonalDetailUrl = WebUI.getUrl()

