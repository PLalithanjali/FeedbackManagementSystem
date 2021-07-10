import { Component, OnInit } from '@angular/core';
import { SkillSet } from 'src/app/trainer/skillset';
import { Trainer } from 'src/app/trainer/trainer';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';


@Component({
  selector: 'app-list-skill',
  templateUrl: './list-skill.component.html',
  styleUrls: ['./list-skill.component.css']
})
export class ListSkillComponent implements OnInit {

  allTrainers: SkillSet[]=[];
  constructor(private skillService: SkillService) { }
  show=true;
  ngOnInit(): void {
    this.skillService.getAllSkills().subscribe((response) => {
      console.log(response);
      this.allSkills = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

  allSkills: Skill[]=[];
  myError: any = ''
  skill: Skill = {
    skillId: 0,
    skillName: ''
  }

  getTrainersBySkill(skillname:String){
    return this.skillService.getTrainersBySkill(skillname).subscribe((response) => {
      console.log(response);
      this.allTrainers = response;
      this.show = !this.show;
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
