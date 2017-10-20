import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-spreadsheet',
  templateUrl: './spreadsheet.component.html',
  styleUrls: ['./spreadsheet.component.css']
})
export class SpreadsheetComponent implements OnInit {

  data = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
  ];




  constructor() { }

  ngOnInit() {
  }

}
