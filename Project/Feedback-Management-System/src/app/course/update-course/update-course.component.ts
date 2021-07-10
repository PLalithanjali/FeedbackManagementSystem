import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-update-course',
  templateUrl: './update-course.component.html',
  styleUrls: ['./update-course.component.css']
})
export class UpdateCourseComponent implements OnInit {

  course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    noOfDays: 0,
    removed: 0
  }
  allCourses: Course[] = [];
  myError: any;
  show=true;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
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

  toggle(){
    this.show= !this.show;
  }

  updateCourse(newCourse:Course){
    console.log(newCourse);
    return this.courseService.updateCourse(newCourse).subscribe((response) => {
      console.log(response);
      this.course = response;
      this.toggle();
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

}
