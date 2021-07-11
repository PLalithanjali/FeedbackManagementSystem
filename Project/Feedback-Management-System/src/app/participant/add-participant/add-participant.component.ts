import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/login/login.service';
import { Employee } from '../participant';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-add-participant',
  templateUrl: './add-participant.component.html',
  styleUrls: ['./add-participant.component.css']
})
export class AddParticipantComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }
  myError: any;

  participant: Employee = {
    employeeId: 0,
    employeeName: '',
    employeePassword: '',
    employeeRole: ''
  }

  addParticipant(newParticipant: Employee){
    return this.loginService.register(newParticipant).subscribe((response) => {
      console.log(response);
      this.participant = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }
}
