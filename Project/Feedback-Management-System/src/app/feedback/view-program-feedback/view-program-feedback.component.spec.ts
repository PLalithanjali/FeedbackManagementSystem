import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProgramFeedbackComponent } from './view-program-feedback.component';

describe('ViewProgramFeedbackComponent', () => {
  let component: ViewProgramFeedbackComponent;
  let fixture: ComponentFixture<ViewProgramFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewProgramFeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProgramFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
