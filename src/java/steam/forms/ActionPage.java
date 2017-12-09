package steam.forms;

import framework.BasePage;
import framework.elements.*;

import org.openqa.selenium.By;



public class ActionPage extends BasePage {

  private Label discountRow = new Label(By.xpath("//div[@id='DiscountsRows']//a"));
  private Label discountLabel = new Label(By.xpath("//div[@id='tab_select_Discounts']"));
  private String patternForDiscount = "//div[@id='DiscountsRows']//a[%s]//div[contains(@class, 'pct')]";
  private String patternForPrice = "//div[@id='DiscountsRows']//a[%s]//div[contains(@class,'final')]";
  private String addonForName = "/following::div[contains(@class,'name')]";
  private static String name;
  private static double price = 0;
  private static int maxDiscount = 0;

  public void navigateDiscounts() {
    discountLabel.click();
  }

  public static int getMaxDiscount() {
    return maxDiscount;
  }

  public static String getGameName() {
    return name;
  }

  public static double getPrice() {
    return price;
  }

  public void findMaxDiscount() {
    String locatorForDiscount;
    discountRow.waitForstaleness();
    int maxIndex = 1;
    Label maxElement = new Label(By.xpath(String.format(patternForDiscount, 1)));
    for (int i = 1; i <= discountRow.getSizeOfList(); i++) {
      locatorForDiscount = String.format(patternForDiscount, i);
      Label buffer = new Label(By.xpath(locatorForDiscount));
      if (Integer.parseInt(buffer.getText().replaceAll("\\D+", "")) > Integer.parseInt(maxElement.getText().replaceAll("[^0-9\\.]", ""))) {
        maxElement = buffer;
        maxIndex = i;
      }
    }
    maxDiscount = Integer.parseInt(maxElement.getText().replaceAll("\\D+", ""));
    price = Double.parseDouble(new Label(By.xpath(String.format(patternForPrice, maxIndex))).getText().replaceAll("[^0-9\\.]",""));
    name = new Label(By.xpath(String.format(patternForDiscount,maxIndex) + addonForName)).getText();
    maxElement.click();
  }
}



