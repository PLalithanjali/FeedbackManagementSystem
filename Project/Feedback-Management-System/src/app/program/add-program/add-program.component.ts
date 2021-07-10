import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/course/course';
import { CourseService } from 'src/app/course/course.service';
import { Trainer } from 'src/app/trainer/trainer';
import { TrainerService } from 'src/app/trainer/trainer.service';
import { Program } from '../program';
import { ProgramService } from '../program.service';

@Component({
  selector: 'app-add-program',
  templateUrl: './add-program.component.html',
  styleUrls: ['./add-program.component.css']
})
export class AddProgramComponent implements OnInit {

  constructor(private programService: ProgramService, private trainerService: TrainerService,
                      private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getAllCourses().subscribe((response) => {
      console.log(response);
      this.allCourses = response;
    },
    (error) => {
      console.log(error.error.message);
      this.allCourses = [];
      this.myError = error.error.message;
    });

    this.trainerService.getAllTrainers().subscribe((response) => {
      console.log(response);
      this.allTrainers = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });

  }
  i :number=0;
  myError: any = ''

  allCourses: Course[]=[];

  allTrainers: Trainer[]=[];
  
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
  

  addProgram(newProgram: Program){
    for(this.i=0;this.i<this.allCourses.length;this.i++){
      if(this.allCourses[this.i].courseName == newProgram.course.courseName){
        newProgram.course={...this.allCourses[this.i]}
        break;
      }
    }
    for(this.i=0;this.i<this.allTrainers.length;this.i++){
      if(this.allTrainers[this.i].trainerName == newProgram.trainer.trainerName){
        newProgram.trainer={...this.allTrainers[this.i]}
        break;
      }
    }
    console.log(newProgram);
    console.log(newProgram.course.courseId);
    return this.programService.addProgram(newProgram).subscribe((response) => {
      console.log(response);
      this.program = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }


}
