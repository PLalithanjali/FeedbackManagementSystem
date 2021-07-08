import { Component } from '@angular/core';
import { AuthService } from './login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Feedback-Management-System';

  constructor(private authService: AuthService){}

  getUser(){
    return this.authService.retrieveUserDetails();
  }
}
