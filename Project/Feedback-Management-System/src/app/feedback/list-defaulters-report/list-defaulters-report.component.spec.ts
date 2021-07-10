import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDefaultersReportComponent } from './list-defaulters-report.component';

describe('ListDefaultersReportComponent', () => {
  let component: ListDefaultersReportComponent;
  let fixture: ComponentFixture<ListDefaultersReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListDefaultersReportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDefaultersReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
