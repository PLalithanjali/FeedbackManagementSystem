import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/participant/participant';
import { AuthService } from '../auth.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router, private authService: AuthService) { }

  user: Employee= {
    employeeId: 0,
    employeeName: '',
    employeePassword: '',
    employeeRole: ''
  };
  myError: any='';
  ngOnInit(): void {
  }

  login(){
    console.log(this.user.employeeName, this.user.employeePassword, this.user.employeeRole);
    this.loginService.login(this.user).subscribe((response) => {
      console.log(response);
      this.authService.storeUserDetails(JSON.stringify(response));
      this.authService.setRole(this.user.employeeRole);
      if(this.user.employeeRole == "admin"){
      this.router.navigate(['home-admin']);
      }
      else if(this.user.employeeRole == "coordinator"){
        this.router.navigate(['home-coordinator']);
      }
      else{
        this.router.navigate(['home-participant']);
      }
    },
    (error) => {
      console.log(error.error.message);
      this.myError=error.error.message;
    });
  }

  getRole(): String{
    return this.user.employeeRole;
  }

}
