import { Component, OnInit } from '@angular/core';
import { Program } from '../program';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-view-program-bydate',
  templateUrl: './view-program-bydate.component.html',
  styleUrls: ['./view-program-bydate.component.css']
})
export class ViewProgramBydateComponent implements OnInit {

  constructor(private programService: ProgramService) { }

  ngOnInit(): void {
  }

  myError: any = ''
  allPrograms:Program[]=[]
  program: Program = {
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
    trainer:{
      trainerId: 0,
      trainerName: ''
    },
    removed: 0
}

  getProgramByDate(date: Date){
    return this.programService.getProgramByDate(date).subscribe((response) => {
      console.log(response);
      this.allPrograms = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
