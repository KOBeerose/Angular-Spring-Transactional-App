import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddImmobilierComponent } from './add-immobilier.component';

describe('AddImmobilierComponent', () => {
  let component: AddImmobilierComponent;
  let fixture: ComponentFixture<AddImmobilierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddImmobilierComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddImmobilierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
