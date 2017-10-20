import {protractor, ElementArrayFinder,  ElementFinder} from 'protractor/built';
import { element, by, browser } from 'protractor';
import { SecTest1FrontendPage } from './app.po';

describe('spreadsheet tests', () => {
  let cells: ElementFinder[];

  beforeEach(() => {
    browser.get('/spreadsheet');
    element.all(by.xpath('//td'))
      .then((cellArray: ElementFinder[]) => {
        cells = cellArray;
    });
  });

  it('should have cells with consecutive numbers', () => {
    cells.forEach((cell, i) => {
      const num = i + 1;
      expect(cell.getText()).toBe(`${num}`);
    });
  });


  it('should change cell', () => {
    browser.actions().doubleClick(cells[0])
      .sendKeys('hola', protractor.Key.TAB)
      .perform();
    expect(cells[0].getText()).toBe('hola');
  });

  it('should change cell 2', () => {
    browser.actions().doubleClick(cells[0])
      .sendKeys('hola', protractor.Key.TAB)
      .perform();
    expect(cells[0].getText()).not.toBe('1');
  });
});
