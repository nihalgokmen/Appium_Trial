import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator_Test {

    AndroidDriver<AndroidElement> driver; // Android cizahlar icin kullanilmasi gerek driver
   // AppiumDriver<AndroidElement> driver2; // hem android hem de ios cihazlar icin kullanilabilen driver(Android icin bu driver kullanilabilir)
   // AppiumDriver<MobileElement> driver3; // ios icin kullanilir (Android cihazlar icin de kullanilabilir)

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // Eger ki kullandigimiz android surumu 6 veya ustuyse UiAutomator2 kullanilir

        capabilities.setCapability(MobileCapabilityType.APP,"/Users/nihal/IdeaProjects/APPIUM-T113-main/Apps/Calculator_8.4.1 (520193683)_Apkpure.apk");
        // Eger ki kullandigimiz android surumu 6 veya ustuyse UiAutomator2 kullanilir

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.activateApp("com.google.android.calculator");
        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular
        // AC butonuna tiklayarak ana ekrani temizler

    }

}
