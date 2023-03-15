package com.training.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.base.LoggerHelper;

import java.util.Random;

public class BillingInfo {

	WebDriverWait wait;
	private final Logger log = LoggerHelper.getLogger(BillingInfo.class);

	public BillingInfo(WebDriver driver) {
		System.out.println("************************" + driver);
		wait = new WebDriverWait(driver, 40);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='/app/flow']")
	private WebElement select_Flow;
	@FindBy(how = How.XPATH, using = "//a[@href='/app/org-profile/team-members']")
	private WebElement teamMembers;
	@FindBy(how = How.XPATH, using = "//a[@href='/app/org-profile/company-info']")
	private WebElement companyInfo;
	@FindBy(how = How.XPATH, using = "//a[@href='/app/org-profile/billing-info']")
	//@FindBy(how = How.XPATH, using = "//div[contains(text(),'Billing Info')]")
	private WebElement billing_Info;
	@FindBy(how = How.XPATH, using = "//a[@href='/app/org-profile/audit-logs']")
	private WebElement auditLogs;
	@FindBy(how = How.XPATH, using = "//a[@href='/app/org-profile/billing-info']//following::div[2]")
	private WebElement flowSettings;


	@FindBy(how = How.XPATH, using = "//input[@name='registeredName']")
	private WebElement RegisterName;
	@FindBy(how = How.XPATH, using = "//input[@name='pinCode']")
	private WebElement PinCode;
	@FindBy(how = How.XPATH, using = "//div[label[text()='Country']]/div")
	private WebElement Country;
	@FindBy(how = How.XPATH, using = "//input[@name='billingAddress']")
	private WebElement BillingAddress;
	@FindBy(how = How.XPATH, using = "//input[@name='gstNumber']")
	private WebElement GSTNumber;
	@FindBy(how = How.XPATH, using = "//input[@name='pan']")
	private WebElement PANnum;
	@FindBy(how = How.XPATH, using = "//input[@name='tan']")
	private WebElement TAN;
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	private WebElement Name;
	@FindBy(how = How.XPATH, using = "//input[@name='phoneNumber']")
	private WebElement ConNum;
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	private WebElement Email;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Save')]")
	private WebElement Save;
	@FindBy(how = How.XPATH, using = "//div[text()='Leave Page ?']")
	private WebElement LeavePage;

	//change xpaths
	@FindBy(how = How.XPATH, using = "//button[@data-test-id='cancel']")
	private WebElement No;
	@FindBy(how = How.XPATH, using = "//button[@data-test-id='success']")
	private WebElement Yes;


	public void select_TeamMembers() {
		teamMembers.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void select_billingInfo() {
		wait.until(ExpectedConditions.visibilityOf(billing_Info));
		billing_Info.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void select_CompanyInfo() {
		companyInfo.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void select_FlowSettings() {
		flowSettings.click();

	}

	public void select_AuditLogs() {
		auditLogs.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void Regis() {

		RegisterName.isEnabled();
	}

	public void enterpin(String pincode) {
		wait.until(ExpectedConditions.visibilityOf(PinCode));
		PinCode.sendKeys(pincode);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void bill(String Bill_add) {
		try {
			Thread.sleep(5000);
			BillingAddress.sendKeys(Bill_add);
		} catch (InterruptedException e) {
		}
	}

	public void GST(String GsT) {
		try {
			Thread.sleep(5000);
			GSTNumber.sendKeys(GsT);
		} catch (InterruptedException e) {
		}
	}

	public void PAN(String Pan) {
		try {
			Thread.sleep(5000);
			PANnum.sendKeys(Pan);
		} catch (InterruptedException e) {
		}
	}

	public void TAn(String Tan) {
		try {
			Thread.sleep(5000);
			TAN.sendKeys(Tan);
		} catch (InterruptedException e) {
		}
	}


	public void NaMe(String NamE) {
		Name.sendKeys(NamE);
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
		}
	}


	public void Cont(String contact) {
		ConNum.sendKeys(contact);
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
		}
	}

	public void emailid(String email) {
		Email.sendKeys(email);
		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
		}
	}


	public void click_save() {
		Save.click();
	}


	public void clear_pincode() {
		PinCode.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PinCode.sendKeys(Keys.DELETE);
		PinCode.sendKeys(Keys.TAB);
		log.info("Cleared pincode");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clear_billadd() {
		BillingAddress.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		BillingAddress.sendKeys(Keys.DELETE);
		BillingAddress.sendKeys(Keys.TAB);
		log.info("Cleared bill add");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clearGST() {
		GSTNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		GSTNumber.sendKeys(Keys.DELETE);
		GSTNumber.sendKeys(Keys.TAB);
		log.info("Cleared GST");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clearpan() {
		PANnum.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		PANnum.sendKeys(Keys.DELETE);
		PANnum.sendKeys(Keys.TAB);
		log.info("Cleared pan num");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void cleartan() {
		TAN.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		TAN.sendKeys(Keys.DELETE);
		TAN.sendKeys(Keys.TAB);
		log.info("Cleared tan num");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clear_contact() {
		ConNum.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		ConNum.sendKeys(Keys.DELETE);
		ConNum.sendKeys(Keys.TAB);
		log.info("Cleared contact");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clear_Name() {
		Name.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Name.sendKeys(Keys.DELETE);
		Name.sendKeys(Keys.TAB);
		log.info("Cleared name");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void clear_email() {
		Email.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Email.sendKeys(Keys.DELETE);
		Email.sendKeys(Keys.TAB);
		log.info("Cleared email");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}

	public void leavepage(String YesNO) {
		//wait.until(ExpectedConditions.visibilityOf(LeavePage));
		if (YesNO.equalsIgnoreCase("No_dont")) {
			No.click();
		}
		if (YesNO.equalsIgnoreCase("Yes_leave")) {
			Yes.click();
		}
	}
	   public  void RanPan(String PAN){
		int numOfUsers = 1;
			//generateIDs(1);
			for (int i = 0; i < numOfUsers; i++) {
				Random r = new Random();

				// char first = (char) (r.nextInt(26)+'A');
				//char first = (char) r.nextInt('w');
				char second = (char) (r.nextInt(26) + 'A');
				char third = (char) (r.nextInt(26) + 'A');
				char fifth = (char) (r.nextInt(12) + 'B');
				int sixth = r.nextInt((8991 - 1001) + 1001) + 1001;
				char seventh = (char) (r.nextInt(1) + 'A');


				PAN = "A" + second + third + "P" + fifth + sixth + seventh;
				//generatedIDs.add(id);
				System.out.println(PAN);
				PANnum.sendKeys(PAN);
					try {
						Thread.sleep(5000);

					} catch (InterruptedException e) {

				}

			}
		}
	}




