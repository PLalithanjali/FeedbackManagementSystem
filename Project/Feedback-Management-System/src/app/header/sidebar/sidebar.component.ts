import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationEnd, provideRoutes } from '@angular/router';
import { CourseService } from 'src/app/course/course.service';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  selection: any;

  constructor(private authService: AuthService) { 
    }


  ngOnInit(): void {
  }

  getUser(){
    return this.authService.retrieveUserDetails();
  }
  getActive(){
    return this.authService.getActive();
  }
  getRole(){
    return this.authService.getRole();
  }
}
