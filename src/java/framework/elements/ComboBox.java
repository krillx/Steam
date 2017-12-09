package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ComboBox extends BaseElement {

  private Select select;

  public ComboBox(By locator) {
        super(locator);
  }

  public Select getSelect() {
    this.select = new Select(getElement());
    return select;
  }

  public void selectByValue(String valueOfSelect) {
    this.select = new Select(getElement());
    getSelect().selectByValue(valueOfSelect);
  }
}
