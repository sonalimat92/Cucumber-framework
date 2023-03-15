package stepDefinitions;

import java.util.List;
import java.util.Set;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.training.config.ConfigFileReader;
import com.training.pageObjects.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Billing_info{

    WebDriver driver ;
   
    String MainWindow;
    Set<String> allWindowHandles;
   
    ConfigFileReader cfg=new ConfigFileReader();
    BillingInfo billinginfo;
  
    WebDriverWait wait;
  //  private final Logger log = LoggerHelper.getLogger(Billing_info.class);

    @Given("^Navigate to Org Setting and select billing info page using credentials \"([^\"]*)\" \"([^\"]*)\"$")
    public void navigate_to_Org_Setting_and_select_flow_page_using_credentials(String username1, String password1) throws Throwable {
       // log.info("==============================================");
       // log.info("Launching the browser");
       // log.info("==============================================");

      //  driver = TestBase.getWebDriver();
      //  TestBase.loadUrl();
        wait = new WebDriverWait(driver,30);
      
        MainWindow=driver.getWindowHandle();
       
        allWindowHandles = driver.getWindowHandles();
        for(String handle :allWindowHandles)
        {
         //   log.info("Window handle - > " + handle); }
        driver.switchTo().window((String) allWindowHandles.toArray()[1]);

      

        driver.switchTo().window((String) allWindowHandles.toArray()[0]);
        }
    }

   @When("^Give invalid Pincode and Click on save \"([^\"]*)\"$")
   public void giveInvalidPincodeAndClickOnSave(String InvalidPincode  ) {
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Billing Information')]")));
       billinginfo.clear_pincode();
       billinginfo.clear_billadd();
       billinginfo.clearGST();
       billinginfo.clearpan();
       billinginfo.cleartan();
       billinginfo.clear_contact();
       billinginfo.clear_Name();
       billinginfo.clear_email();
       System.out.println("Fields are cleared");

       billinginfo.enterpin(InvalidPincode);
       billinginfo.click_save();
   }

    @Then("^Verify that proper error messages should be displayed$")
    public void verify_that_proper_error_messages_should_be_displayed(DataTable field) throws Throwable {
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@role='alert']"))); log.info(cfg.getXPath(driver, "alert").getText());
		 * Assert.assertEquals("Invalid form details", cfg.getXPath(driver,
		 * "alert").getText()); List<List<String>> data = field.raw(); for (int i = 0; i
		 * < data.size(); i++) { if (data.get(i).get(0) == "pincode")
		 * Assert.assertEquals("PIN required", cfg.getXPath(driver,
		 * "pin_billinginfo").getAttribute("errorlabel")); if (data.get(i).get(0) ==
		 * "GST")
		 * Assert.assertEquals("Valid GST is required for this field",cfg.getXPath(
		 * driver,"gst_billinginfo").getAttribute("errorlabel")); if (data.get(i).get(0)
		 * == "PAN")
		 * Assert.assertEquals("Valid PAN is required for this field",cfg.getXPath(
		 * driver,"pan_billinginfo").getAttribute("errorlabel")); if (data.get(i).get(0)
		 * == "TAN") Assert.assertEquals("TAN number required",cfg.getXPath(driver,
		 * "tan_billinginfo").getAttribute("errorlabel")); if (data.get(i).get(0) ==
		 * "phone") Assert.assertEquals("Invalid phone number",cfg.getXPath(driver,
		 * "cont_billinginfo").getAttribute("errorlabel")); if (data.get(i).get(0) ==
		 * "email") Assert.assertEquals("Invalid email number",cfg.getXPath(driver,
		 * "email_billinginfo").getAttribute("errorlabel"));
		 */     
    }
    @When("^Give Billing address and Click on save\"([^\"]*)\"$")
    public void BillinfoAndSave(String Bill_add) {
        billinginfo.clear_billadd();
        billinginfo.bill(Bill_add);
        billinginfo.click_save();
    }
    @When("^Give invalid GST Number and Click on save \"([^\"]*)\"$")
    public void giveInvalidGSTNumberAndClickOnSave(String invalidGST)  {
       billinginfo.GST(invalidGST);
       billinginfo.click_save();
    }
    @When("^Give invalid PAN number and Click on save \"([^\"]*)\"$")
    public void giveInvalidPANNumberAndClickOnSave(String invalidPan ) {
     billinginfo.PAN(invalidPan);
     billinginfo.click_save();
    }
    @When("^Give invalid TAN Number and Click on save \"([^\"]*)\"$")
    public void giveInvalidTANNumberAndClickOnSave(String invalidtan){
        billinginfo.TAn(invalidtan);
        billinginfo.click_save();
    }
    @Then("^Provide pincode \"([^\"]*)\",Billing address \"([^\"]*)\",GST \"([^\"]*)\",PAN \"([^\"]*)\",TAn number\"([^\"]*)\"$")
    public void providePincodeBillingAddressGSTPANTAnNumber(String pincode,String Bill_add, String GsT, String PAN, String Tan)  {
       billinginfo.clear_pincode();
       billinginfo.clear_billadd();
       billinginfo.clearGST();
       billinginfo.clearpan();
       billinginfo.cleartan();

       billinginfo.enterpin(pincode);
       billinginfo.bill(Bill_add);
       billinginfo.GST(GsT);
       billinginfo.RanPan(PAN);
       billinginfo.TAn(Tan);
    }
    @Then("^click on save button$")
    public void clickOnSaveButton() {
        billinginfo.click_save();
    }

    @When("^Give Name Click on save button \"([^\"]*)\"$")
    public void giveNameClickOnSaveButton(String NamE) {
       billinginfo.NaMe(NamE);
        billinginfo.click_save();
    }
    @When("^Give invalid contact Click on save button \"([^\"]*)\"$")
    public void giveInvalidContactClickOnSaveButton(String invalidcontact) {
        billinginfo.Cont(invalidcontact);
        billinginfo.click_save();
    }
    @When("^Give contact Click on save button \"([^\"]*)\"$")
    public void giveContactClickOnSaveButton(String contact) {
      billinginfo.clear_contact();
       billinginfo.Cont(contact);
       billinginfo.click_save(); 
    }
    @When("^Give invalid Email id Click on save button \"([^\"]*)\"$")
    public void giveInvalidEmailIdClickOnSaveButton(String email) {
      
    }
    @When("^Give Name,Contact number, Email and click on save \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void giveNameContactNumberEmailAndClickOnSave(String NamE, String contact, String email) throws Throwable {
      
    }

    @Then("^Click on save button$")
   public void clickOnSaveButton1() throws Throwable{


    }

    @When("^Edit email and navigate to flow setting tab \"([^\"]*)\"$")
    public void editEmailAndNavigateToFlowSettingTab(String newemail) {
       
    }

    @Then("^Leave Page popup should appear and clicking on No,dont remains in same page\"([^\"]*)\"$")
    public void leavePagePopupShouldAppearAndClickingOnNoDontRemainsInSamePage(String action_no) throws Throwable {
      

    }

    @When("^Edit contact and navigate to flow setting tab \"([^\"]*)\"$")
    public void editContactAndNavigateToFlowSettingTab(String newcontact)throws Throwable {
      

    }

    @Then("^Leave Page popup should appear and clicking on Yes, Leave navigates to flowsetting without saving the changes\"([^\"]*)\"$")
    public void leavePagePopupShouldAppearAndClickingOnYesLeaveNavigatesToFlowsettingWithoutSavingTheChanges(String action_yes) throws Throwable {
       
    }

    @Then("^Go Back to Home and Close the Browser$")
    public void goBackToHomeAndCloseTheBrowser()throws Throwable {
		/*
		 * FlowSettings flowSettings=new FlowSettings(driver);
		 * flowSettings.select_BackToHome(); HomePage homePage=new HomePage(driver);
		 * homePage.clickOn_User(); homePage.clickOn_Logout(); TestBase.closeDriver();
		 */
    }
}


