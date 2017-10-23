import {protractor, ElementArrayFinder,  ElementFinder} from 'protractor/built';
import { element, by, browser } from 'protractor';
import { SecTest1FrontendPage } from './app.po';


// Estas pruebas están escritas con una librería llamada "Protractor"
// Ver: http://www.protractortest.org/#/tutorial
describe('spreadsheet tests', () => {
  let cells: ElementFinder[];

  beforeEach(() => {
    // Abre el navegador en la URL indicada
    browser.get('/spreadsheet');

    // Obtiene todas las celdas de tablas presentes en la hoja de cálculo con id="mytable"
    // Ver tutorial de Xpath para más detalles: https://www.w3schools.com/xml/xpath_syntax.asp
    element.all(by.xpath('//hottable[@id="mytable"]//td'))
      .then((cellArray: ElementFinder[]) => {
        // Guarda en la variable 'cells' un arreglo que contiene todas las celdas de la hoja de cálculo
        cells = cellArray;
    });
  });

  it('should have cells with consecutive numbers', () => {
    cells.forEach((cell, i) => {
      const num = i + 1;
      expect(cell.getText()).toBe(`${num}`);
    });
  });

  it('should change cell, test 1', () => {
    browser.actions().doubleClick(cells[0])
      .sendKeys('hola', protractor.Key.TAB)
      .perform();
    expect(cells[0].getText()).toBe('hola');
  });

  it('should change cell, test 2', () => {
    browser.actions().doubleClick(cells[0])
      .sendKeys('hola', protractor.Key.TAB)
      .perform();
    expect(cells[0].getText()).not.toBe('1');
  });

  it('should change three cells', () => {
    browser.actions().click(cells[0])
      .sendKeys('hola0', protractor.Key.TAB)
      .sendKeys('hola1', protractor.Key.TAB)
      .sendKeys('hola2', protractor.Key.TAB)
      .perform();
    expect(cells[0].getText()).toBe('hola0');
    expect(cells[1].getText()).toBe('hola1');
    expect(cells[2].getText()).toBe('hola2');
  });

});
