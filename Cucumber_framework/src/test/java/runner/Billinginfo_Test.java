package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.training.base.TestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RunWith(Cucumber.class)

@CucumberOptions( features = "src/test/resources/functionalTests/" ,
        glue = "stepDefinitions" ,
        tags = "@Billinginfo" ,
        monochrome = true ,
        dryRun=false,
        plugin= { "com.cucumber.listener.ExtentCucumberFormatter:Reports/Billinginfo.html"} )



public class Billinginfo_Test {

    @BeforeClass
    public static void setup() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        File destinationDir = new File(System.getProperty("user.dir") + "/Reports/");
        destinationDir.mkdirs();
        String reportPath=destinationDir+File.separator;
        //ExtentReports report=new ExtentReports(reportPath+currentTime+".html");
        //  extentProperties.setReportPath(reportPath+currentTime+".html"); //used same string name to create the file with the same name.
    }
    @AfterClass

    public static void writeExtentReport() {
        //TestBase.closeDriver();
        Reporter.loadXMLConfig("./configs/extentConfig.xml");
        Reporter.setSystemInfo("User name", System.getProperty("user.name"));
        Reporter.setSystemInfo("TimeZone", System.getProperty("user.timeZone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0"); Reporter.setSystemInfo("Maven",
                "3.5.3"); Reporter.setSystemInfo("Java Version", "1.8.0_151"); }

}