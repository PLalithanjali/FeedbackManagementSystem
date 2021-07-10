import { Component, OnInit } from '@angular/core';
import { Program } from 'src/app/program/program';
import { ProgramService } from 'src/app/program/program.service';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-view-program-feedback',
  templateUrl: './view-program-feedback.component.html',
  styleUrls: ['./view-program-feedback.component.css']
})
export class ViewProgramFeedbackComponent implements OnInit {

  constructor(private feedbackService: FeedbackService, private programService: ProgramService) { }

  show=true;
  program: Program={
    programId: 0,
    startDate: new Date(),
    endDate: new Date(),
    course: {
      courseId: 0,
      courseName: '',
      courseDescription: '',
      noOfDays: 0,
      removed: 0
    },
    trainer: {
      trainerId: 0,
      trainerName: ''
    },
    removed: 0
  }
  ngOnInit(): void {this.programService.getAllPrograms().subscribe((response) => {
    console.log(response);
    this.allPrograms = response;
    
  },
  (error) => {
    console.log(error.error.message);
    this.myError = error.error.message;
  });
}
i=0;
myError: any = ''

allPrograms: Program[]=[];
 allFeedbacks: Feedback[] = [];

  getFeedbackByProgram(programId: number){
    this.myError='';
    return this.feedbackService.getFeedbackByProgram(programId).subscribe((response) => {
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
