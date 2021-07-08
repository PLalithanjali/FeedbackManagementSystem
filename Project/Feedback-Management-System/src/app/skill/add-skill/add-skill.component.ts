import { Component, OnInit } from '@angular/core';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';

@Component({
  selector: 'app-add-skill',
  templateUrl: './add-skill.component.html',
  styleUrls: ['./add-skill.component.css']
})
export class AddSkillComponent implements OnInit {

  constructor(private trainerService: SkillService) { }

  ngOnInit(): void {
  }

  myError: any = ''
  skill: Skill = {
    skillId: 0,
    skillName: ''
  }

  addSkill(newSkill:Skill){
    newSkill = this.skill;
    return this.trainerService.addSkill(newSkill).subscribe((response) => {
      console.log(response);
      this.skill = response;
      
    },
    (error) => {
      console.log(error.error.message);
      this.myError = error.error.message;
    });
  }

}
