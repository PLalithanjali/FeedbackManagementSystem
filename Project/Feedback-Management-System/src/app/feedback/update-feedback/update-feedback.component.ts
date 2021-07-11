import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/login/auth.service';
import { Employee } from 'src/app/participant/participant';
import { ParticipantService } from 'src/app/participant/participant.service';
import { Program } from 'src/app/program/program';
import { ProgramService } from 'src/app/program/program.service';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-update-feedback',
  templateUrl: './update-feedback.component.html',
  styleUrls: ['./update-feedback.component.css']
})
export class UpdateFeedbackComponent implements OnInit {

  constructor(private feedbackService: FeedbackService, private programService: ProgramService,
              private participantService: ParticipantService,
                private authService: AuthService) { }

  ngOnInit(): void {
    this.allEmpFeedbacks=[];
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
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });

    let user: any='';
    user = this.authService.retrieveUserDetails();
    if(user!=null){
    let ename = JSON.parse(user).user.employeeName;
    console.log("name: "+ename);
    this.employeeName = ename;
    console.log("Employeename: "+this.employeeName);
    }
    this.getFeedback();

  }
  employeeName:String='';
  allDefaulters: Feedback[]=[];
  allEmpFeedbacks: Feedback[]=[];
  allPrograms: Program[]=[];
  allParticipants: Employee[]=[];
  i:number=0;
  myError:any=''
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
  show=true;
  length=0;

  getFeedback(){
    this.feedbackService.getAllDefaulters().subscribe((response) => {
      console.log(response);
      this.allDefaulters = response;
      for(this.i=0;this.i<this.allDefaulters.length;this.i++){
        if(this.allDefaulters[this.i].employee.employeeName == this.employeeName){
          this.allEmpFeedbacks.push(this.allDefaulters[this.i]);
        }
      }
      this.length=this.allEmpFeedbacks.length;
      console.log("emp"+this.allEmpFeedbacks);
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

  updateFeedback(newFeedback: Feedback){
    for(this.i=0;this.i<this.allParticipants.length;this.i++){
      if(this.allParticipants[this.i].employeeName == this.employeeName){
        newFeedback.employee={...this.allParticipants[this.i]}
        break;
      }
    }
    for(this.i=0;this.i<this.allPrograms.length;this.i++){
      if(this.allPrograms[this.i].programId == newFeedback.program.programId){
        newFeedback.program={...this.allPrograms[this.i]}
        break;
      }
    }
    return this.feedbackService.updateFeedback(newFeedback).subscribe((response) => {
      console.log(response);
      this.feedback = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
