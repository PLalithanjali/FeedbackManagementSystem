import { Component, OnInit } from '@angular/core';
import { Program } from '../program';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-delete-program',
  templateUrl: './delete-program.component.html',
  styleUrls: ['./delete-program.component.css']
})
export class DeleteProgramComponent implements OnInit {

  constructor(private programService: ProgramService) { }

  ngOnInit(): void {
    this.programService.getAllPrograms().subscribe((response) => {
      console.log(response);
      this.allPrograms = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

  myError: any = ''
  allPrograms: Program[]=[];
  
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

  deleteProgram(newProgram: Program){
    return this.programService.deleteProgram(newProgram).subscribe((response) => {
      console.log(response);
      this.program = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
