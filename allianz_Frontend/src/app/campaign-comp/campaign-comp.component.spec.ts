import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaignCompComponent } from './campaign-comp.component';

describe('CampaignCompComponent', () => {
  let component: CampaignCompComponent;
  let fixture: ComponentFixture<CampaignCompComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CampaignCompComponent]
    });
    fixture = TestBed.createComponent(CampaignCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
