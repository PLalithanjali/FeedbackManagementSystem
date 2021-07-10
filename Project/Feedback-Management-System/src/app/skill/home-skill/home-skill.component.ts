import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-skill',
  templateUrl: './home-skill.component.html',
  styleUrls: ['./home-skill.component.css']
})
export class HomeSkillComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  activeComponent: string='skill';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
    this.router.navigate(['list-skill']);
  }

}
