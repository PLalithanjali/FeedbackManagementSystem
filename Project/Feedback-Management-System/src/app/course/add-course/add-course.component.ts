import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  constructor(private courseService: CourseService) { }

  myError: any;

  course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    noOfDays: 0,
    removed: 0
  }

  ngOnInit(): void {
  }
  
  addCourse(newCourse:Course){
    newCourse = this.course;
    return this.courseService.addCourse(newCourse).subscribe((response) => {
      console.log(response);
      this.course = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

}
