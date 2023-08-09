import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CampaigndetailComponent } from './campaigndetail.component';

describe('CampaigndetailComponent', () => {
  let component: CampaigndetailComponent;
  let fixture: ComponentFixture<CampaigndetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CampaigndetailComponent]
    });
    fixture = TestBed.createComponent(CampaigndetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
