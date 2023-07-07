package Tests;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C04_TestBaseHomePageScreenShot extends TestBaseBeforeAfter{



    @Test
    public void Test01() throws IOException, InterruptedException {
        cap.setCapability("app", "C:\\Ucms\\Ucs.Ucms26.Designer 2.6.144.3\\Ucs.Ucms26.Designer.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);

        Actions actions =new Actions(driver);

        driver.findElementByAccessibilityId("txtUserName").clear();
        driver.findElementByAccessibilityId("txtUserName").sendKeys("can");
        driver.findElementByAccessibilityId("txtPassword").clear();
        driver.findElementByAccessibilityId("txtPassword").sendKeys("x");
        //driver.findElementByAccessibilityId("cmdLogin").click();
        actions.click(driver.findElementByAccessibilityId("cmdLogin")).perform();

        /*String UcsWindowHandles = driver.findElementByAccessibilityId("TitleBa")
        System.out.println("UcsWindowHandles = " + UcsWindowHandles);
        driver.switchTo().window(UcsWindowHandles);*/


        //Set<String> windowHandles = driver.getWindowHandles();
        //driver.switchTo().window(windowHandles.iterator().next());


        Thread.sleep(5000);
        String windows = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(windows).getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());


        driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
        TakesScreenshot ts =driver;
        File tümSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tümSayfaResmi,new File("target/TümSayfaResmi/AllPage "+tarih+".jpeg"));
        driver.findElementByXPath("//Button[@Name='Close']").click();
        driver.findElementByAccessibilityId("cmdOk").click();


    }
}
