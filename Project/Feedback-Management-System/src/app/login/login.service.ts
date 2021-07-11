import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../participant/participant';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(newUser: Employee): Observable<Employee> {
    return this.http.post<Employee>("http://localhost:8080/authenticate",newUser);
  }

  register(newUser: Employee): Observable<Employee> {
    return this.http.post<Employee>("http://localhost:8080/register",newUser);
  }
}
