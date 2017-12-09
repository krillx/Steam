package steam.forms;

import framework.BasePage;
import framework.PropertiesReader;
import framework.elements.*;
import org.openqa.selenium.By;

public class ValidateAgeForm extends BasePage {

  private Label submitAgeLable = new Label(By.xpath("//div[@id='agegate_box']//a"));
  private Label submitAgeLableWithoutAge = new Label(By.xpath("//div[@id='app_agegate']//a[contains(@onclick, 'Age')]"));
  private PropertiesReader properties = new PropertiesReader();

  public void chooseAgeValidate() {
    if (submitAgeLableWithoutAge.isEnabled()) {
      submitAgeLableWithoutAge.click();
    } else if (submitAgeLable.isEnabled()) {
      validateAge();
    }
  }

  public void validateAge() {
    ComboBox day = new ComboBox(By.name("ageDay"));
    ComboBox month = new ComboBox(By.name("ageMonth"));
    ComboBox year = new ComboBox(By.name("ageYear"));
    day.selectByValue(properties.getDay());
    month.selectByValue(properties.getMonth());
    year.selectByValue(properties.getYear());
    submitAgeLable.click();
  }
}

