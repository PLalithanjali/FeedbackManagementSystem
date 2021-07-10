import { Component, OnInit } from '@angular/core';
import { Skill } from '../skill';
import { SkillService } from '../skill.service';

@Component({
  selector: 'app-delete-skill',
  templateUrl: './delete-skill.component.html',
  styleUrls: ['./delete-skill.component.css']
})
export class DeleteSkillComponent implements OnInit {

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

  deleteSkill(newSkill:Skill){
    return this.skillService.deleteSkill(newSkill).subscribe((response) => {
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
