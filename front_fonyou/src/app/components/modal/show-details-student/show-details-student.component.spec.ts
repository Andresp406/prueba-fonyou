import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowDetailsStudentComponent } from './show-details-student.component';

describe('ShowDetailsStudentComponent', () => {
  let component: ShowDetailsStudentComponent;
  let fixture: ComponentFixture<ShowDetailsStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowDetailsStudentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowDetailsStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
