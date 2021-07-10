import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/skill/skill';
import { SkillService } from 'src/app/skill/skill.service';
import { SkillSet } from 'src/app/trainer/skillset';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer.service';

@Component({
  selector: 'app-add-skills-trainer',
  templateUrl: './add-skills-trainer.component.html',
  styleUrls: ['./add-skills-trainer.component.css']
})
export class AddSkillsTrainerComponent implements OnInit {

  constructor(private skillService: SkillService, private trainerService: TrainerService) { }

  allSkills: Skill[] = [];
  allTrainers: Trainer[] = [];
  myError: any = '';
  j = 0;
  skillSet: SkillSet = {
    skill: {
      skillId: 0,
      skillName: ''
    },
    trainer: {
      trainerId: 0,
      trainerName: ''
    }
  }
  i = 0;
  selectedSkills: Skill[] = [];
  ngOnInit(): void {
    this.trainerService.getAllTrainers().subscribe((response) => {
      console.log(response);
      this.allTrainers = response;
    },
      (error) => {
        console.log(error.error.message);
        this.myError = error.error.message;
      });

    this.skillService.getAllSkills().subscribe((response) => {
      console.log(response);
      this.allSkills = response;
    },
      (error) => {
        console.log(error.error.message);
        this.myError = error.error.message;
      });
  }

  selected(skill: Skill) {
    this.selectedSkills.push(skill);
  }

  addSkillsToTrainer() {
    console.log("selected: " + this.selectedSkills.values());
    for (this.i = 0; this.i < this.allTrainers.length; this.i++) {
      if (this.skillSet.trainer.trainerName == this.allTrainers[this.i].trainerName) {
        this.skillSet.trainer = { ...this.allTrainers[this.i] };
      }
    }
    for (this.i = 0; this.i < this.selectedSkills.length; this.i++) {
      for (this.j = 0; this.j < this.allSkills.length; this.j++) {
        if (this.allSkills[this.j].skillName == this.selectedSkills[this.i].skillName) {
          this.selectedSkills[this.i] = { ...this.allSkills[this.j] };
        }
      }
      for (this.i = 0; this.i < this.selectedSkills.length; this.i++) {
        this.skillSet.skill = { ...this.selectedSkills[this.i] };
        this.trainerService.addSkillsToTrainer(this.skillSet).subscribe((response) => {
          console.log(response);
        },
          (error) => {
            console.log(error.error.message);
            this.myError = error.error.message;
          });
      }
    }

  }

}


