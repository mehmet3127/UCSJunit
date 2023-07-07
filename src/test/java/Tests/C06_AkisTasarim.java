package Tests;

import io.appium.java_client.windows.WindowsDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class C06_AkisTasarim extends TestBaseBeforeAfter {

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
        actions.doubleClick(mehmetDemirKlasör).perform();
        WebElement kampanyaAdı = driver.findElementByName("AUTOMATION_TEST03 (198)");
        actions.doubleClick(kampanyaAdı).perform();
        driver.findElementByAccessibilityId("cmdEdit").click();
        driver.findElementByName("Akış Tasarımı").click();
        WebElement formEkleButton = driver.findElementByName("toolStripButton30");
        formEkleButton.click();

        /*List<WebElement> paneList = driver.findElementsByXPath("//pane");
        System.out.println("paneList = " + paneList);
        driver.switchTo().frame(paneList.get(0));*/



       /*File campainsResmi =campains.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(campainsResmi,new File("target/ObjectEkranGörüntüsü/Object"+tarih+".jpeg"));*/


    }
}
