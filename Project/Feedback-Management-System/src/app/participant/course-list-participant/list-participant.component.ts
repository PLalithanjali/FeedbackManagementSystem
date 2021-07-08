import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/course/course';
import { CourseService } from 'src/app/course/course.service';
import { AuthService } from 'src/app/login/auth.service';
import { Employee } from '../participant';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-list-participant',
  templateUrl: './list-participant.component.html',
  styleUrls: ['./list-participant.component.css']
})
export class ListParticipantComponent implements OnInit {

  constructor(private participantService: ParticipantService, private courseService: CourseService,
            private authService: AuthService) { }

  allParticipants: Employee[]=[];
  allCourses: Course[]=[];
  myError:any='';
  show=true;
  course: Course={
    courseId: 0,
    courseName: '',
    courseDescription: '',
    noOfDays: 0,
    removed: 0
  }
  i=0;

  activeComponent: string='participant';
  participant: Employee = {
    employeeId: 0,
    employeeName: '',
    employeePassword: '',
    employeeRole: ''
  }
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
    this.courseService.getAllCourses().subscribe((response) => {
      console.log(response);
      this.allCourses = response;
    },
    (error) => {
      console.log(error.error.message);
      this.allCourses = [];
      this.myError = error.error.message;
    });
  }

  getAllParticipantsBycourse(){
    this.myError='';
    for(this.i=0;this.i<this.allCourses.length;this.i++){
      if(this.allCourses[this.i].courseName == this.course.courseName){
        this.course={...this.allCourses[this.i]}
        break;
      }
    }
    console.log(this.course.courseId);
    this.participantService.getAllParticipantsBycourse(this.course.courseId).subscribe((response) => {
      console.log(response);
      this.allParticipants = response;
      console.log(this.allParticipants);
      this.show = false;
    },
    (error) => {
      console.log(error.error.message);
      this.allParticipants = [];
      this.myError = error.error.message;
    });
  }

}
