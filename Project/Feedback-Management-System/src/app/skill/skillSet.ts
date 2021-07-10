import { Trainer } from "../trainer/trainer";
import { Skill } from "./skill";

export interface SkillSet{
    skill: Skill,
    trainer: Trainer
}