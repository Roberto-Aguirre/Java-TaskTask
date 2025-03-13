import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftTaksListComponent } from './left-taks-list.component';

describe('LeftTaksListComponent', () => {
  let component: LeftTaksListComponent;
  let fixture: ComponentFixture<LeftTaksListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LeftTaksListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LeftTaksListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
