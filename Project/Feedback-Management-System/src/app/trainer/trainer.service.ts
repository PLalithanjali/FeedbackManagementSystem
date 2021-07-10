import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Skill } from '../skill/skill';
import { SkillSet } from '../trainer/skillset';
import { Trainer } from './trainer';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allTrainers: Trainer[] = [];

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
  

  getAllTrainers(): Observable<Trainer[]>{
    
      return this.http.get<Trainer[]>("http://localhost:8080/admin/trainer-management/all-trainers", this.getHttpOptions());
  }

  addTrainer(newTrainer: Trainer): Observable<Trainer>{

    return this.http.post<Trainer>("http://localhost:8080/admin/trainer-management/add-trainer",newTrainer, this.getHttpOptions());
  
  }

  updateTrainer(newTrainer: Trainer): Observable<Trainer>{
    console.log(newTrainer);
    return this.http.put<Trainer>("http://localhost:8080/admin/trainer-management/update-trainer",newTrainer, this.getHttpOptions());
  
  }

  deleteTrainer(newTrainer: Trainer): Observable<Trainer>{
    console.log(newTrainer.trainerId);
    return this.http.delete<Trainer>("http://localhost:8080/admin/trainer-management/delete-trainer/"+newTrainer.trainerId, this.getHttpOptions());
  
  }

  addSkillsToTrainer(skillset: SkillSet): Observable<SkillSet>{
    return this.http.post<SkillSet>("http://localhost:8080/skillset/add-skillset",skillset, this.getHttpOptions());
  
  }

}
