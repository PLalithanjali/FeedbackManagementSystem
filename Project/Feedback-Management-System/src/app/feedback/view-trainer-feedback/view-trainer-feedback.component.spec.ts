import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTrainerFeedbackComponent } from './view-trainer-feedback.component';

describe('ViewTrainerFeedbackComponent', () => {
  let component: ViewTrainerFeedbackComponent;
  let fixture: ComponentFixture<ViewTrainerFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTrainerFeedbackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTrainerFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
