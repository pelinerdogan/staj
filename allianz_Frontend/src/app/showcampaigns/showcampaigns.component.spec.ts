import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcampaignsComponent } from './showcampaigns.component';

describe('ShowcampaignsComponent', () => {
  let component: ShowcampaignsComponent;
  let fixture: ComponentFixture<ShowcampaignsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowcampaignsComponent]
    });
    fixture = TestBed.createComponent(ShowcampaignsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
