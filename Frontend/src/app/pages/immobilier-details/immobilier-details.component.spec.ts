import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImmobilierDetailsComponent } from './immobilier-details.component';

describe('ImmobilierDetailsComponent', () => {
  let component: ImmobilierDetailsComponent;
  let fixture: ComponentFixture<ImmobilierDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImmobilierDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImmobilierDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
