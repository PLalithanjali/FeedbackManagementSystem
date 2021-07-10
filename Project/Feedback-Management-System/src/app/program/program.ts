import { Course } from "../course/course";
import { Trainer } from "../trainer/trainer";

export interface Program{
    programId: number,
    startDate: Date,
    endDate: Date,
    course: Course
    trainer: Trainer,
    removed: number
}