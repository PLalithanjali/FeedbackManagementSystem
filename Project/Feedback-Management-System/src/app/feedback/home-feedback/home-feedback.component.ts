import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-feedback',
  templateUrl: './home-feedback.component.html',
  styleUrls: ['./home-feedback.component.css']
})
export class HomeFeedbackComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  activeComponent: string='feedback';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
  }
}
