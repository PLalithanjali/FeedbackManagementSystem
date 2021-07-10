import { Component, OnInit } from '@angular/core';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer.service';

@Component({
  selector: 'app-add-trainer',
  templateUrl: './add-trainer.component.html',
  styleUrls: ['./add-trainer.component.css']
})
export class AddTrainerComponent implements OnInit {

  constructor(private trainerService: TrainerService) { }

  ngOnInit(): void {
  }

  myError: any = ''
  trainer: Trainer = {
    trainerId: 0,
    trainerName: ''
  }

  addTrainer(newTrainer:Trainer){
    newTrainer = this.trainer;
    return this.trainerService.addTrainer(newTrainer).subscribe((response) => {
      console.log(response);
      this.trainer = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
