import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApprouveAccountComponent } from './approuve-account.component';

describe('ApprouveAccountComponent', () => {
  let component: ApprouveAccountComponent;
  let fixture: ComponentFixture<ApprouveAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApprouveAccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ApprouveAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
