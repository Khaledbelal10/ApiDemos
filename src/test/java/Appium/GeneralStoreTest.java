package Appium;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

public class GeneralStoreTest extends Base{
	@Test
	public void doHybrid() throws InterruptedException {

		//Scroll and select Canada option from dropDown
   	 driver.findElement(By.id("android:id/text1")).click();
   	 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();

	//Type name in a text field
		  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Jeniffer");
		  driver.hideKeyboard(); // hide keyboard

  //Select radio option
		  driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

   // scroll until Air Jordan 9
		  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"));"));

         int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
         for(int i=0; i<count; i++) {
        	 String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	    if(productName.equalsIgnoreCase("Air Jordan 9 Retro")) {
        	    	driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();

        	    }
         }

         driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
         Thread.sleep(2000);
         driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
         Thread.sleep(6000);
        Set<String> s = driver.getContextHandles();
        s.forEach(System.out::println);

        //1. Convert to WebView
        driver.context("WEBVIEW_com.androidsample.generalstore");

        // 2.Smart Waiting
        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(15));
         //handleing web
        Set<String> wizardHandles = driver.getWindowHandles();
        for(String handle : wizardHandles) {
            driver.switchTo().window(handle);
            // We try if this current page is the one that has the search element in order to install it
            try {
                if(!driver.findElements(By.name("q")).isEmpty()) {
                    break;
                }
            } catch(Exception e) {
                // If the page is still loading or not the right one, continue to the next one.
            }
        }

        // 3. Wait until the element becomes compressible and then write in it.
        org.openqa.selenium.WebElement searchField = wait.until(
                org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(By.name("q"))
        );

        searchField.sendKeys("codenbox");
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(2000);
        driver.context("NATIVE_APP");}}