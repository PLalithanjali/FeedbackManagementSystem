import { Component, OnInit } from '@angular/core';
import { Program } from '../program';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-update-program',
  templateUrl: './update-program.component.html',
  styleUrls: ['./update-program.component.css']
})
export class UpdateProgramComponent implements OnInit {

  constructor(private programService: ProgramService) { }

  allPrograms: Program[]=[];
  show=true;
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

  updateProgram(newProgram: Program){
    return this.programService.updateProgram(newProgram).subscribe((response) => {
      console.log(response);
      this.program = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

  toggle(){
    this.show = !this.show;
  }

}
