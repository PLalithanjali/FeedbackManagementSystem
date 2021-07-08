import { Component, OnInit } from '@angular/core';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-view-trainer-feedback',
  templateUrl: './view-trainer-feedback.component.html',
  styleUrls: ['./view-trainer-feedback.component.css']
})
export class ViewTrainerFeedbackComponent implements OnInit {

  constructor(private feedbackService: FeedbackService) { }

  ngOnInit(): void {
  }

  myError:any=''
 allFeedbacks: Feedback[] = [];

 getFeedbackByTrainer(programId: number){
    return this.feedbackService.getFeedbackByTrainer(programId).subscribe((response) => {
      console.log(response);
      this.allFeedbacks = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }
}
