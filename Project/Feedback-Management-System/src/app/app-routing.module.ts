import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCourseComponent } from './course/add-course/add-course.component';
import { DeleteCourseComponent } from './course/delete-course/delete-course.component';
import { HomeCourseComponent } from './course/home-course/home-course.component';
import { ListCourseComponent } from './course/list-course/list-course.component';
import { UpdateCourseComponent } from './course/update-course/update-course.component';
import { ViewCourseComponent } from './course/view-course/view-course.component';
import { HomeFeedbackComponent } from './feedback/home-feedback/home-feedback.component';
import { ListDefaultersReportComponent } from './feedback/list-defaulters-report/list-defaulters-report.component';
import { UpdateFeedbackComponent } from './feedback/update-feedback/update-feedback.component';
import { ViewProgramFeedbackComponent } from './feedback/view-program-feedback/view-program-feedback.component';
import { ViewTrainerFeedbackComponent } from './feedback/view-trainer-feedback/view-trainer-feedback.component';
import { HomeAdminComponent } from './login/home-admin/home-admin.component';
import { HomeCoordinatorComponent } from './login/home-coordinator/home-coordinator.component';
import { HomeParticipantComponent } from './login/home-participant/home-participant.component';
import { HomeComponent } from './login/home/home.component';
import { LoginComponent } from './login/login/login.component';
import { LogoutComponent } from './login/logout/logout.component';
import { AddParticipantComponent } from './participant/add-participant/add-participant.component';
import { ListParticipantComponent } from './participant/course-list-participant/list-participant.component';
import { EnrollParticipantComponent } from './participant/enroll-participant/enroll-participant.component';
import { AddProgramComponent } from './program/add-program/add-program.component';
import { DeleteProgramComponent } from './program/delete-program/delete-program.component';
import { HomeProgramComponent } from './program/home-program/home-program.component';
import { ListProgramComponent } from './program/list-program/list-program.component';
import { UpdateProgramComponent } from './program/update-program/update-program.component';
import { ViewProgramComponent } from './program/view-program/view-program.component';
import { AddSkillComponent } from './skill/add-skill/add-skill.component';
import { DeleteSkillComponent } from './skill/delete-skill/delete-skill.component';
import { HomeSkillComponent } from './skill/home-skill/home-skill.component';
import { ListSkillComponent } from './skill/list-skill/list-skill.component';
import { UpdateSkillComponent } from './skill/update-skill/update-skill.component';
import { AddSkillsTrainerComponent } from './trainer/add-skills-trainer/add-skills-trainer.component';
import { AddTrainerComponent } from './trainer/add-trainer/add-trainer.component';
import { DeleteTrainerComponent } from './trainer/delete-trainer/delete-trainer.component';
import { HomeTrainerComponent } from './trainer/home-trainer/home-trainer.component';
import { ListTrainerComponent } from './trainer/list-trainer/list-trainer.component';
import { UpdateTrainerComponent } from './trainer/update-trainer/update-trainer.component';

const routes: Routes = [
  { path:'add-course', component: AddCourseComponent },
  { path:'list-course', component: ListCourseComponent },
  { path:'login', component: LoginComponent },
  { path:'logout', component: LogoutComponent },
  { path:'home', component: HomeComponent },
  { path:'course', component: HomeCourseComponent },
  { path:'trainer', component: HomeTrainerComponent },
  { path:'feedback', component: HomeFeedbackComponent },
  { path:'program', component: HomeProgramComponent },
  { path:'participant', component: ListParticipantComponent },
  { path:'skill', component: HomeSkillComponent },
  { path:'update-course', component: UpdateCourseComponent },
  { path:'list-course/update-course', component: UpdateCourseComponent },
  { path:'list-course/delete-course', component: DeleteCourseComponent },
  { path:'delete-course', component: DeleteCourseComponent },
  { path:'view-course', component: ViewCourseComponent },
  { path:'home-admin', component: HomeAdminComponent },
  { path:'home-coordinator', component: HomeCoordinatorComponent },
  { path:'home-participant', component: HomeParticipantComponent },
  { path:'add-trainer', component: AddTrainerComponent },
  { path:'add-skill-trainer', component: AddSkillsTrainerComponent },
  { path:'update-trainer', component: UpdateTrainerComponent },
  { path:'list-trainer', component: ListTrainerComponent },
  { path:'delete-trainer', component: DeleteTrainerComponent },
  { path:'view-trainer', component: ListTrainerComponent },
  { path:'add-participant', component: AddParticipantComponent },
  { path:'list-participant', component: ListParticipantComponent },
  { path:'enroll-participant', component: EnrollParticipantComponent },
  { path:'add-program', component: AddProgramComponent },
  { path:'update-program', component: UpdateProgramComponent },
  { path:'delete-program', component: DeleteProgramComponent },
  { path:'list-program', component: ListProgramComponent },
  { path:'view-program', component: ViewProgramComponent },
  { path:'update-feedback', component: UpdateFeedbackComponent },
  { path:'add-skill', component: AddSkillComponent },
  { path:'update-skill', component: UpdateSkillComponent },
  { path:'delete-skill', component: DeleteSkillComponent },
  { path:'list-skill', component: ListSkillComponent },
  { path:'list-program-feedback', component: ViewProgramFeedbackComponent },
  { path:'list-trainer-feedback', component: ViewTrainerFeedbackComponent },
  { path:'list-default-report', component: ListDefaultersReportComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
