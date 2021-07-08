import { Employee } from "../participant/participant";
import { Program } from "../program/program";

export interface Feedback{
    feedbackId: number,
    employee: Employee,
    program: Program,
    feedbackCriteria1: number,
    feedbackCriteria2: number,
    feedbackCriteria3: number,
    feedbackCriteria4: number,
    feedbackCriteria5: number,
    comments: String,
    suggestions: String
}