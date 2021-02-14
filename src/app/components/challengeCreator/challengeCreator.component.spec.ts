import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChallengeCreatorComponent } from './challengeCreator.component';

describe('ChallengeCreatorComponent', () => {
  let component: ChallengeCreatorComponent;
  let fixture: ComponentFixture<ChallengeCreatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChallengeCreatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChallengeCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
