import { Component, OnInit } from '@angular/core';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';

@Component({
  selector: 'app-update-skill',
  templateUrl: './update-skill.component.html',
  styleUrls: ['./update-skill.component.css']
})
export class UpdateSkillComponent implements OnInit {

  constructor(private skillService: SkillService) { }
  allSkills: Skill[]=[];
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

  myError: any = ''
  skill: Skill = {
    skillId: 0,
    skillName: ''
  }

  updateSkill(newSkill:Skill){
    newSkill = this.skill;
    return this.skillService.updateSkill(newSkill).subscribe((response) => {
      console.log(response);
      this.skill = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }
  toggle(){
    this.show= !this.show;
  }

}
