import { Component, Input, OnInit } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input()
  inputSideNav!: MatSidenav;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  opened = true;

  getRole(): String{
    return this.authService.getRole();
  }

  getUser(){
    return this.authService.retrieveUserDetails();
  }

}
