import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allfeedbacks: Feedback[] = [];

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
  

  getAllDefaulters(): Observable<Feedback[]>{
    
      return this.http.get<Feedback[]>("http://localhost:8080/feedback/trainer/feedback-report-defaulters", this.getHttpOptions());
  }

  updateFeedback(newFeedback: Feedback): Observable<Feedback>{
    console.log(newFeedback);
    return this.http.put<Feedback>("http://localhost:8080/feedback/participant/update-feedback",newFeedback, this.getHttpOptions());
  
  }

  getFeedbackByTrainer(trainerId: number): Observable<Feedback[]>{
    console.log(trainerId);
    return this.http.delete<Feedback[]>("http://localhost:8080/feedback/feedback-report-trainer/"+trainerId, this.getHttpOptions());
  
  }

  getFeedbackByProgram(programId: number): Observable<Feedback[]>{
    return this.http.get<Feedback[]>("http://localhost:8080/feedback/feedback-report-program/"+programId, this.getHttpOptions());
  
  }

}
