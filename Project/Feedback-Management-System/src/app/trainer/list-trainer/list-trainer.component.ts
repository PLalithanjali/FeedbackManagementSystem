import { Component, OnInit } from '@angular/core';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer.service';

@Component({
  selector: 'app-list-trainer',
  templateUrl: './list-trainer.component.html',
  styleUrls: ['./list-trainer.component.css']
})
export class ListTrainerComponent implements OnInit {

  constructor(private trainerService: TrainerService) { }
  
  myError: any='';
  allTrainers: Trainer[]=[];
  trainer: Trainer={
    trainerId: 0,
      trainerName: ''
  }

  ngOnInit(): void {
    this.trainerService.getAllTrainers().subscribe((response) => {
      console.log(response);
      this.allTrainers = response;
    },
    (error) => {
      console.log(error.error.message);
      this.allTrainers = [];
      this.myError = error.error.message;
    });
  }


}
