import { browser, by, element } from 'protractor';

export class SecTest1FrontendPage {
  navigateTo() {
    return browser.get('/spreadsheet');
  }

  getParagraphText() {
    return element(by.css('app-root h1')).getText();
  }
}
