import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyImmobilierComponent } from './my-immobilier.component';

describe('MyImmobilierComponent', () => {
  let component: MyImmobilierComponent;
  let fixture: ComponentFixture<MyImmobilierComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyImmobilierComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyImmobilierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
