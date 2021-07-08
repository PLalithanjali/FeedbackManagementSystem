import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Program } from './program';

@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allPrograms: Program[] = [];

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
  

  getAllPrograms(): Observable<Program[]>{
    
      return this.http.get<Program[]>("http://localhost:8080/program/all-programs", this.getHttpOptions());
  }

  addProgram(newProgram: Program): Observable<Program>{

    return this.http.post<Program>("http://localhost:8080/program/add-program",newProgram, this.getHttpOptions());
  
  }

  updateProgram(newProgram: Program): Observable<Program>{
    console.log(newProgram);
    return this.http.put<Program>("http://localhost:8080/program/update-program",newProgram, this.getHttpOptions());
  
  }

  deleteProgram(newProgram: Program): Observable<Program>{
    console.log(newProgram.programId);
    return this.http.delete<Program>("http://localhost:8080/program/delete-program/"+newProgram.programId, this.getHttpOptions());
  
  }

  getProgramByDate(date: Date): Observable<Program[]>{
    return this.http.get<Program[]>("http://localhost:8080/program/program-bydate/"+date, this.getHttpOptions());
  
  }
}
