import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-skill',
  templateUrl: './home-skill.component.html',
  styleUrls: ['./home-skill.component.css']
})
export class HomeSkillComponent implements OnInit {

  constructor(private authService: AuthService) { }

  activeComponent: string='skill';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
  }

}
