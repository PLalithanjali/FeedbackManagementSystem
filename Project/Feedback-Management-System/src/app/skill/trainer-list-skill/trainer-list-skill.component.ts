import { Component, OnInit } from '@angular/core';
import { SkillSet } from 'src/app/trainer/skillset';
import { Trainer } from 'src/app/trainer/trainer';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';


@Component({
  selector: 'app-trainer-list-skill',
  templateUrl: './trainer-list-skill.component.html',
  styleUrls: ['./trainer-list-skill.component.css']
})
export class TrainerListSkillComponent implements OnInit {

  constructor(private skillService: SkillService) { }

  ngOnInit(): void {this.skillService.getAllSkills().subscribe((response) => {
    console.log(response);
    this.allSkills = response;
    
  },
  (error) => {
    console.log(error.error.message);
    this.myError = error.error.message;
  });
}

allSkills: Skill[]=[];
  allTrainers: SkillSet[]=[];
  myError: any = ''
  
  skill: Skill = {
    skillId: 0,
    skillName: ''
  }
  show=true;
  

  getTrainersBySkill(skillname:String){
    return this.skillService.getTrainersBySkill(skillname).subscribe((response) => {
      console.log(response);
      this.allTrainers = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });

}
}
