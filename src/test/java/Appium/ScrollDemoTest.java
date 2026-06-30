package Appium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemoTest extends Base {

	@Test
	public void scrollTest() throws InterruptedException {
		// 1. Access the Views page
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		Thread.sleep(2000); // انتظر حتى تفتح الصفحة تماماً

		// 2. Scroll works to search for an element containing the letters "ele" (such as Expandable Lists).)
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"ele\"));"
		));
		Thread.sleep(1000);

		// 3. Scroll until you find the "WebView" element with the exact same name.ً
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"WebView\"));"
		));
		Thread.sleep(1000);

		// 4. Using the custom method from the Base class
		// scrollToElement("WebView");

		// 5. Scroll to the very end of the application (make sure the method is in the class)
		scrollToEnd();
	}
}