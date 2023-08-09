import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavigationcompComponent } from './navigationcomp.component';

describe('NavigationcompComponent', () => {
  let component: NavigationcompComponent;
  let fixture: ComponentFixture<NavigationcompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavigationcompComponent]
    });
    fixture = TestBed.createComponent(NavigationcompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
