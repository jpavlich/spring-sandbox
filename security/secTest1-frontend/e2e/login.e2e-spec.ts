import {protractor, ElementArrayFinder,  ElementFinder} from 'protractor/built';
import { element, by, browser } from 'protractor';
import { SecTest1FrontendPage } from './app.po';


// Estas pruebas están escritas con una librería llamada "Protractor"
// Ver: http://www.protractortest.org/#/tutorial
describe('login tests', () => {

  let txtLogin: ElementFinder;
  let txtPass: ElementFinder;
  let btnLogin: ElementFinder;

  beforeEach(() => {
    // Abre el navegador en la URL indicada
    browser.get('/login');

    txtLogin = element(by.xpath('//input[@name="user"]'));
    txtPass = element(by.xpath('//input[@name="pass"]'));
    btnLogin = element(by.xpath('//button[@id="login"]'));
  });

  it('should login successfully', () => {
    txtLogin.sendKeys('user');
    txtPass.sendKeys('password');
    btnLogin.click();
  });
});
