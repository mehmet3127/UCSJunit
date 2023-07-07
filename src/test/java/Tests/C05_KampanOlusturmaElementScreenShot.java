package Tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C05_KampanOlusturmaElementScreenShot extends TestBaseBeforeAfter {

    @Test
    public void name() {

    }

    @Test
    public void Test01() throws IOException, InterruptedException {
        cap.setCapability("app", "C:\\Ucms\\Ucs.Ucms26.Designer 2.6.144.3\\Ucs.Ucms26.Designer.exe");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);

        Actions actions = new Actions(driver);

        driver.findElementByAccessibilityId("txtUserName").clear();
        driver.findElementByAccessibilityId("txtUserName").sendKeys("can");
        driver.findElementByAccessibilityId("txtPassword").clear();
        driver.findElementByAccessibilityId("txtPassword").sendKeys("x");
        //driver.findElementByAccessibilityId("cmdLogin").click();
        actions.click(driver.findElementByAccessibilityId("cmdLogin")).perform();


        Thread.sleep(5000);
        String windows = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(windows).getTitle();


        driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);

        WebElement campains = driver.findElementByName("Campaigns");
        actions.doubleClick(campains).perform();
        WebElement mehmetDemirKlasör = driver.findElementByName("MehmetDemir");
        actions.contextClick(mehmetDemirKlasör).perform();
        driver.findElementByName("Kampanya Ekle").click();
        driver.findElementByAccessibilityId("txtCampaignName").sendKeys("SeleniumAutomationTest_06");
        driver.findElementByAccessibilityId("cmdSave").click();
        driver.findElementByAccessibilityId("cmdEdit").click();
        driver.findElementByAccessibilityId("chkCampOutbound").click();
        driver.findElementByAccessibilityId("cmdSelectResultId").click();
        actions.doubleClick(driver.findElementByName("Cagri Cevaplanmadi (3)")).perform();
        driver.findElementByName("Mesgul (1071)").click();
        driver.findElementByAccessibilityId("cmdOk").click();
        driver.findElementByAccessibilityId("cmdCampSave").click();



       /*
       File campainsResmi =campains.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(campainsResmi,new File("target/ObjectEkranGörüntüsü/Object"+tarih+".jpeg"));
        */





    }

}
