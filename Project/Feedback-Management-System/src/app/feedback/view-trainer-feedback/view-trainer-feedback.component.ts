import { Component, OnInit } from '@angular/core';
import { Trainer } from 'src/app/trainer/trainer';
import { TrainerService } from 'src/app/trainer/trainer.service';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-view-trainer-feedback',
  templateUrl: './view-trainer-feedback.component.html',
  styleUrls: ['./view-trainer-feedback.component.css']
})
export class ViewTrainerFeedbackComponent implements OnInit {

  constructor(private feedbackService: FeedbackService, private trainerService: TrainerService) { }

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
 allFeedbacks: Feedback[] = [];
 i=0;

 getFeedbackByTrainer(){
  for(this.i=0;this.i<this.allTrainers.length;this.i++){
    if(this.allTrainers[this.i].trainerName == this.trainer.trainerName){
      this.trainer={...this.allTrainers[this.i]}
      break;
    }
  }
   this.myError='';
    return this.feedbackService.getFeedbackByTrainer(this.trainer.trainerId).subscribe((response) => {
      console.log(response);
      this.allFeedbacks = response;
      this.show=false;
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }
}
