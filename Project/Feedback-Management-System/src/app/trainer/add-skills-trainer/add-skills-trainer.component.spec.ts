import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSkillsTrainerComponent } from './add-skills-trainer.component';

describe('AddSkillsTrainerComponent', () => {
  let component: AddSkillsTrainerComponent;
  let fixture: ComponentFixture<AddSkillsTrainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSkillsTrainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSkillsTrainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
