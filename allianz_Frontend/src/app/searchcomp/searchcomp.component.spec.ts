import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchcompComponent } from './searchcomp.component';

describe('SearchcompComponent', () => {
  let component: SearchcompComponent;
  let fixture: ComponentFixture<SearchcompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SearchcompComponent]
    });
    fixture = TestBed.createComponent(SearchcompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
