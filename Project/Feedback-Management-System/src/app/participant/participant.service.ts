import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../feedback/feedback';
import { AuthService } from '../login/auth.service';
import { Employee } from './participant';

@Injectable({
  providedIn: 'root'
})
export class ParticipantService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allparticipants: Employee[] = [];

  getHttpOptions(){
    let user: any='';
    let httpOptions={}; 
    user = this.authService.retrieveUserDetails();
    if(user!=null){
    let token = JSON.parse(user).token;
    console.log('token: '+token);
    httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': 'Bearer ' + token
      })
      }
    }
    return httpOptions;
  }
  
  getAllParticipants(): Observable<Employee[]>{
    
    return this.http.get<Employee[]>("http://localhost:8080/participant/all-participants/",this.getHttpOptions());
}

  getAllParticipantsBycourse(courseId: number): Observable<Employee[]>{
    
      return this.http.get<Employee[]>("http://localhost:8080/participant/all-participants/"+courseId,this.getHttpOptions());
  }

  addParticipant(newParticipant: Employee): Observable<Employee>{

    return this.http.post<Employee>("http://localhost:8080/participant/add-participant",newParticipant, this.getHttpOptions());
  
  }

  enrollParticipant(newFeedback: Feedback): Observable<Feedback>{
    console.log(newFeedback);
    return this.http.post<Feedback>("http://localhost:8080/participant/enroll-participant",newFeedback, this.getHttpOptions());
  
  }
}
