import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-trainer',
  templateUrl: './home-trainer.component.html',
  styleUrls: ['./home-trainer.component.css']
})
export class HomeTrainerComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  activeComponent: string='trainer';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
    this.router.navigate(['list-trainer']);
  }
}
