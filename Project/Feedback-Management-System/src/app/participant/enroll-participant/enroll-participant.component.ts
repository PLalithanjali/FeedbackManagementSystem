import { Component, OnInit } from '@angular/core';
import { Feedback } from 'src/app/feedback/feedback';
import { Employee } from '../participant';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-enroll-participant',
  templateUrl: './enroll-participant.component.html',
  styleUrls: ['./enroll-participant.component.css']
})
export class EnrollParticipantComponent implements OnInit {

  constructor(private participantService: ParticipantService) { }

  feedback: Feedback={
    feedbackId: 0,
    employee: {
      employeeId: 0,
      employeeName: '',
      employeePassword: '',
      employeeRole: ''
    },
    program: {
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
    },
    feedbackCriteria1: 0,
    feedbackCriteria2: 0,
    feedbackCriteria3: 0,
    feedbackCriteria4: 0,
    feedbackCriteria5: 0,
    comments: '',
    suggestions: ''
  }

  ngOnInit(): void {
  }
  myError: any;

  enrollParticipant(newFeedback: Feedback){
    newFeedback = this.feedback;
    return this.participantService.enrollParticipant(newFeedback).subscribe((response) => {
      console.log(response);
      this.feedback = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }



}
