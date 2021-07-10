import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-program',
  templateUrl: './home-program.component.html',
  styleUrls: ['./home-program.component.css']
})
export class HomeProgramComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  activeComponent: string='program';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
    this.router.navigate(['list-program']);
  }

}
