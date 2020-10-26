import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WatchClubComponent } from './watch-club.component';

describe('WatchClubComponent', () => {
  let component: WatchClubComponent;
  let fixture: ComponentFixture<WatchClubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WatchClubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WatchClubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
