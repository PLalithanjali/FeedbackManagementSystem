import { Component, OnInit } from '@angular/core';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-list-defaulters-report',
  templateUrl: './list-defaulters-report.component.html',
  styleUrls: ['./list-defaulters-report.component.css']
})
export class ListDefaultersReportComponent implements OnInit {

  constructor(private feedbackService: FeedbackService) { }

  allDefaulters: Feedback[]=[];
  myError: any='';
  ngOnInit(): void {
    
    this.feedbackService.getAllDefaulters().subscribe((response) => {
      console.log(response);
      this.allDefaulters = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

}
