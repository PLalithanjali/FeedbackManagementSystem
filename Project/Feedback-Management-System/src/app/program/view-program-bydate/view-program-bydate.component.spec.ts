import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewProgramBydateComponent } from './view-program-bydate.component';

describe('ViewProgramBydateComponent', () => {
  let component: ViewProgramBydateComponent;
  let fixture: ComponentFixture<ViewProgramBydateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewProgramBydateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewProgramBydateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
