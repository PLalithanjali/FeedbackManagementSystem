import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-home-course',
  templateUrl: './home-course.component.html',
  styleUrls: ['./home-course.component.css']
})
export class HomeCourseComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  activeComponent: string='course';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
    this.router.navigate(['list-course']);
  }
}
