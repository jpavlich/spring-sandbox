/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { SpreadsheetComponent } from './spreadsheet.component';

describe('SpreadsheetComponent', () => {
  let component: SpreadsheetComponent;
  let fixture: ComponentFixture<SpreadsheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpreadsheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpreadsheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
