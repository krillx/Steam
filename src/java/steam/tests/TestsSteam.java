package steam.tests;

import framework.Browser;
import framework.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import steam.forms.*;
import steam.menus.GameMenu;

import javax.swing.*;

import static framework.BaseEntity.currentBrowser;

public class TestsSteam {
  private PropertiesReader properties = new PropertiesReader();
  private String language = properties.getLanguage();

  @BeforeTest
  public void startBrowser() {
    Browser.getInstance().navigateSteam(properties.readUrl());
  }

  @Test
  public void testSteam() throws Exception {
    MainPage mainPage = new MainPage(language);
    mainPage.changeLanguage();
    mainPage.gameMenu.navigateMenu(GameMenu.TopOfMenu.GAMES, GameMenu.ElementOfMenu.ACTIONS);

    ActionPage actionPage = new ActionPage();
    actionPage.navigateDiscounts();
    actionPage.findMaxDiscount();

    ValidateAgeForm validateAgeForm = new ValidateAgeForm();
    validateAgeForm.chooseAgeValidate();

    GamePage gamePage = new GamePage();
    Assert.assertEquals(gamePage.getDiscount(),actionPage.getMaxDiscount());
    Assert.assertEquals(gamePage.getPrice(),actionPage.getPrice());
    Assert.assertEquals(gamePage.getName(),actionPage.getGameName());
    gamePage.navigateSteamDownloadPage();

    DownloadSteamPage downloadSteamPage = new DownloadSteamPage();
    downloadSteamPage.checkExistanse();
    Assert.assertTrue(downloadSteamPage.isFileDownloaded());

  }

  @AfterTest
  public void closeBrowser() {
    currentBrowser.closeDriver();
  }

}
