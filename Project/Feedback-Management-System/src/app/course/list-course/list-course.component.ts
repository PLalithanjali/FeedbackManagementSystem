import { Component, OnInit } from '@angular/core';
import { Course } from '../course';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-list-course',
  templateUrl: './list-course.component.html',
  styleUrls: ['./list-course.component.css']
})
export class ListCourseComponent implements OnInit {

  constructor(private courseService: CourseService) { }

  course: Course = {
    courseId: 0,
    courseName: '',
    courseDescription: '',
    noOfDays: 0,
    removed: 0
  }
  allCourses: Course[] = [];
  myError: any;
  title: String = 'Welcome to All Courses!!';

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

}
