import { Component, OnInit } from '@angular/core';
import { Feedback } from 'src/app/feedback/feedback';
import { Program } from 'src/app/program/program';
import { ProgramService } from 'src/app/program/program.service';
import { Employee } from '../participant';
import { ParticipantService } from '../participant.service';

@Component({
  selector: 'app-enroll-participant',
  templateUrl: './enroll-participant.component.html',
  styleUrls: ['./enroll-participant.component.css']
})
export class EnrollParticipantComponent implements OnInit {

  constructor(private participantService: ParticipantService,private programService: ProgramService) { }

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
  allPrograms: Program[]=[];
  allParticipants: Employee[]=[];
  i=0;

  ngOnInit(): void {
    this.programService.getAllPrograms().subscribe((response) => {
      console.log(response);
      this.allPrograms = response;
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });

    this.participantService.getAllParticipants().subscribe((response) => {
      console.log(response);
      this.allParticipants = response;
      console.log(this.allParticipants);
    },
    (error) => {
      console.log(error.error.message);
      this.allParticipants = [];
      this.myError = error.error.message;
    });
  }
  myError: any;
  

  enrollParticipant(newFeedback: Feedback){
    for(this.i=0;this.i<this.allParticipants.length;this.i++){
      if(this.allParticipants[this.i].employeeName == this.feedback.employee.employeeName){
        this.feedback.employee={...this.allParticipants[this.i]}
        break;
      }
    }
    console.log(newFeedback);
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
