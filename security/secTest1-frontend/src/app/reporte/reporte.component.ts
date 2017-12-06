import { Component } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';

declare var Stimulsoft: any;

@Component({
  selector: 'app-root',
  template: `<div>
                  <h2>Stimulsoft Reports.JS Designer</h2>
                  <div id="designer"></div>
              </div>`
})
export class ReporteComponent {
  options: any;
  designer: any;
  report: any;
  archivo: any;

  ngOnInit() {
    console.log('Loading Designer view');

    console.log('Set full screen mode for the designer');
    this.options = new Stimulsoft.Designer.StiDesignerOptions();
    this.options.appearance.fullScreenMode = true;

    console.log('Create the report designer with specified options');
    this.designer = new Stimulsoft.Designer.StiDesigner(this.options, 'StiDesigner', false);

    console.log('Edit report template in the designer');
    this.designer.report = new Stimulsoft.Report.StiReport();
    this.designer.report.loadFile('http://localhost:8080/reporte/designer');
    console.log('Rendering the designer to selected element');
    this.designer.renderHtml('designer');


    console.log('Loading completed successfully!');
  }

  constructor(
  ) {
  }
}
