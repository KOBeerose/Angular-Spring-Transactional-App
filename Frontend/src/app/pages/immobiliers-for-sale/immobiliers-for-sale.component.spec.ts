import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImmobiliersForSaleComponent } from './immobiliers-for-sale.component';

describe('ImmobiliersForSaleComponent', () => {
  let component: ImmobiliersForSaleComponent;
  let fixture: ComponentFixture<ImmobiliersForSaleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImmobiliersForSaleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ImmobiliersForSaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
