import { Component, OnInit } from '@angular/core';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer.service';

@Component({
  selector: 'app-delete-trainer',
  templateUrl: './delete-trainer.component.html',
  styleUrls: ['./delete-trainer.component.css']
})
export class DeleteTrainerComponent implements OnInit {

  constructor(private trainerService: TrainerService) { }

  show=true;
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

  deleteTrainer(newTrainer: Trainer){
    this.trainerService.deleteTrainer(newTrainer).subscribe((response) => {
      console.log(response);
      newTrainer = response;
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

  toggle(){
    this.show= !this.show;
  }

}
