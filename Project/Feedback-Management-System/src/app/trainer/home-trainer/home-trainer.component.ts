import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/auth.service';

@Component({
  selector: 'app-home-trainer',
  templateUrl: './home-trainer.component.html',
  styleUrls: ['./home-trainer.component.css']
})
export class HomeTrainerComponent implements OnInit {

  constructor(private authService: AuthService) { }

  activeComponent: string='trainer';
  
  ngOnInit(): void {
    this.authService.setActive(this.activeComponent);
  }

}
