import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Skill } from './skill';
import { SkillSet } from './skillSet';

@Injectable({
  providedIn: 'root'
})
export class SkillService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allSkills: Skill[] = [];

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
  

  getAllSkills(): Observable<Skill[]>{
    
      return this.http.get<Skill[]>("http://localhost:8080/skill/all-skills", this.getHttpOptions());
  }

  addSkill(newSkill: Skill): Observable<Skill>{

    return this.http.post<Skill>("http://localhost:8080/skill/add-skill",newSkill, this.getHttpOptions());
  
  }

  updateSkill(newSkill: Skill): Observable<Skill>{
    console.log(newSkill);
    return this.http.put<Skill>("http://localhost:8080/skill/update-skill",newSkill, this.getHttpOptions());
  
  }

  deleteSkill(newSkill: Skill): Observable<Skill>{
    console.log(newSkill.skillId);
    return this.http.delete<Skill>("http://localhost:8080/skill/delete-skill/"+newSkill.skillId, this.getHttpOptions());
  
  }

  getTrainersBySkill(skillname: String):Observable<SkillSet[]>{

    return this.http.get<SkillSet[]>("http://localhost:8080/admin/trainer-management/view-trainer-byskill/"+skillname, this.getHttpOptions());
  
  }
}
