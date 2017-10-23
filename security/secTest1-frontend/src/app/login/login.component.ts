import { RestClientService } from './../services/rest-client.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = 'user';
  password = 'password';

  result: any;

  testData: any;




  constructor(private restClient: RestClientService) { }

  ngOnInit() {
  }


  doLogin() {
    console.log(this.user + ' - ' + this.password);
    this.restClient.login(this.user, this.password);

  }

  getTestData() {
    this.restClient.getTestData()
    .subscribe(
      data => {
        console.log('Success' + data);
        this.testData = JSON.stringify(data);
      },
      error => {
        console.error(error);
        this.testData = JSON.stringify(error);
      }
    );

  }

  logout() {
    this.restClient.logout();
  }
}
