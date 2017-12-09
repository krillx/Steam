package steam.forms;

import framework.BasePage;
import framework.LocalePropertiesReader;
import framework.elements.*;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private LocalePropertiesReader properties;
  private String language;
  private Label languageLable = new Label(By.id("language_pulldown"));

  public MainPage(String language) {
    this.language = language;
  }

  public void changeLanguage() {
    createProperties();
    if (!languageLable.getText().equals(properties.getCheckWordForLanguage())) {
      languageMenu.changeLanguage(properties.getLanguage());
    }
  }

  public void createProperties() {
    properties = new LocalePropertiesReader(language);
  }

}
