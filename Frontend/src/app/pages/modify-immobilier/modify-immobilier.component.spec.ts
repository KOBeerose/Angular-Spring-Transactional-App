import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyImmobilierComponent } from './modify-immobilier.component';

describe('ModifyImmobilierComponent', () => {
  let component: ModifyImmobilierComponent;
  let fixture: ComponentFixture<ModifyImmobilierComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ModifyImmobilierComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyImmobilierComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
