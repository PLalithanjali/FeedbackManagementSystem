import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient, private authService: AuthService) { }

  allCourses: Course[] = [];
  open = true;

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

  toggle(){
    this.open = !open;
  }
  

  getAllCourses(): Observable<Course[]>{
    
      return this.http.get<Course[]>("http://localhost:8080/admin/course/all-courses", this.getHttpOptions());
  }

  addCourse(newCourse: Course): Observable<Course>{

    return this.http.post<Course>("http://localhost:8080/admin/course/add-course",newCourse, this.getHttpOptions());
  
  }

  updateCourse(newCourse: Course): Observable<Course>{
    console.log(newCourse);
    return this.http.put<Course>("http://localhost:8080/admin/course/update-course",newCourse, this.getHttpOptions());
  
  }

  deleteCourse(newCourse: Course): Observable<Course>{
    console.log(newCourse.courseId);
    return this.http.delete<Course>("http://localhost:8080/admin/course/delete-course/"+newCourse.courseId, this.getHttpOptions());
  
  }

}

