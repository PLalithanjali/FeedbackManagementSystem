import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/auth.service';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-home-course',
  templateUrl: './home-course.component.html',
  styleUrls: ['./home-course.component.css']
})
export class HomeCourseComponent implements OnInit {

  constructor(private authService: AuthService) { }

  activeComponent: string='course';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
  }
}
