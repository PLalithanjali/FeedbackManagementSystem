import { Component, OnInit } from '@angular/core';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-view-program-feedback',
  templateUrl: './view-program-feedback.component.html',
  styleUrls: ['./view-program-feedback.component.css']
})
export class ViewProgramFeedbackComponent implements OnInit {

  constructor(private feedbackService: FeedbackService) { }

  ngOnInit(): void {
  }

  myError:any=''
 allFeedbacks: Feedback[] = [];

  getFeedbackByProgram(programId: number){
    return this.feedbackService.getFeedbackByProgram(programId).subscribe((response) => {
      console.log(response);
      this.allFeedbacks = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
