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
import java.util.Random
import java.util.UUID

// ===== Generate a random first name and set to dynamic global variable =====
def generateRandomFullName() {
	// Array of First Names
	def firstNames = [
	    "John", "Emily", "David", "Sarah", "Alex", 
	    "Emma", "Michael", "Olivia", "Chris", "Katie", 
	    "Matthew", "Sophia", "Daniel", "Isabella", "Jacob"
	]
	
	// Array of Middle Names
	def middleNames = [
	    "Michael", "Grace", "James", "Elizabeth", "Christopher", 
	    "Rose", "Andrew", "Marie", "Thomas", "Anne", 
	    "Ryan", "Nicole", "Joseph", "Claire", "William"
	]
	
	// Array of Last Names
	def lastNames = [
	    "Smith", "Johnson", "Brown", "Davis", "Miller", 
	    "Wilson", "Moore", "Taylor", "Anderson", "Jackson", 
	    "White", "Harris", "Martin", "Thompson", "Garcia"
	]
	Random random = new Random()
	def random_firstName = firstNames[random.nextInt(firstNames.size())]
	def random_middleName = middleNames[random.nextInt(middleNames.size())]
	def random_lastName = lastNames[random.nextInt(lastNames.size())]
	return [GlobalVariable.empl_dynamicFirstName = random_firstName,GlobalVariable.empl_dynamicMiddleName = random_middleName,GlobalVariable.empl_dynamicLastName = random_lastName]

}

def generateRandomShortUUID() {
    // Generate a UUID
    String uuid = UUID.randomUUID().toString()
    // Return the first 5 characters
    def short_uuid = "_" + uuid.substring(0, 5)
	return GlobalVariable.empl_dynamicEmployeeId = short_uuid
}

generateRandomFullName()
generateRandomShortUUID()
GlobalVariable.empl_dynamicUsername = GlobalVariable.empl_dynamicFirstName + GlobalVariable.empl_dynamicEmployeeId

println(GlobalVariable.empl_dynamicFirstName)
println(GlobalVariable.empl_dynamicMiddleName)
println(GlobalVariable.empl_dynamicLastName)
println(GlobalVariable.empl_dynamicEmployeeId)
println(GlobalVariable.empl_dynamicUsername)