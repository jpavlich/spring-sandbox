import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Injectable } from '@angular/core';
import { Headers } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class RestClientService {

  constructor(private http: Http) { }

  login(user: string, password: string) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    const urlSearchParams = new URLSearchParams();
    urlSearchParams.append('username', user);
    urlSearchParams.append('password', password);

    this.http.post('http://localhost:8080/login', 'username='+user+'&password='+password, { headers: headers, withCredentials: true})
      // .map((res: Response) => res.json())
      .subscribe(
        data => {
          console.log('Success' + data);
        },
        error => {
          console.error(error);
        }
      );
  }

  getTestData() {
    return this.http.post('http://localhost:8080/api/test', '', {withCredentials: true})
      .map((response: Response) => response.json());

  }

  logout() {
    this.http.post('http://localhost:8080/logout', '', {withCredentials: true})
      .subscribe(
        data => {
          console.log('Success' + data);
        },
        error => {
          console.error(error);
        }
      );
  }

}
