package framework;

import framework.BaseEntity;
import steam.menus.GameMenu;
import steam.menus.LanguageMenu;

public class BasePage extends BaseEntity {

  public GameMenu gameMenu = new GameMenu();
  public LanguageMenu languageMenu = new LanguageMenu();


}
