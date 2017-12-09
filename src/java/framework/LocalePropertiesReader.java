package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LocalePropertiesReader {

  private  FileInputStream fis;
  private  Properties property = new Properties();
  private  String path;

  public  LocalePropertiesReader(String language) {
    switch (language) {
      case "EN":
        path = "src/resources/EnglishLocale.properties";
        break;
      case "RU":
        path = "src/resources/RussianLocale.properties";
        break;
      default:
        System.out.println("incorrec Language");
    }

    try {
      fis = new FileInputStream(path);
      property.load(fis);
    } catch (IOException e) {
      e.getStackTrace();
    }
  }

  public String readGamesLocale() {
    return property.getProperty("localeForGames");
  }

  public String readActionLocale() {
    return property.getProperty("LocaleForActions");
  }

  public String getCheckWordForLanguage() {
    return property.getProperty("CheckWordForLanguage");
  }

  public String getLanguage() {
    return property.getProperty("Language");
  }
}

