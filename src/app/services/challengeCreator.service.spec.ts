import { TestBed } from '@angular/core/testing';

import { ChallengeCreatorService } from './challengeCreator.service';

describe('ChallengeCreatorService', () => {
  let service: ChallengeCreatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChallengeCreatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
