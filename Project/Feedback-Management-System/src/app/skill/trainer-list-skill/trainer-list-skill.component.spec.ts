import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerListSkillComponent } from './trainer-list-skill.component';

describe('TrainerListSkillComponent', () => {
  let component: TrainerListSkillComponent;
  let fixture: ComponentFixture<TrainerListSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerListSkillComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerListSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
