import { TestBed } from '@angular/core/testing';

import { AllianzServiceService } from './allianz-service.service';

describe('AllianzServiceService', () => {
  let service: AllianzServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AllianzServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
