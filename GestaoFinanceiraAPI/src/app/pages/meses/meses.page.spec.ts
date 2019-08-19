import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MesesPage } from './meses.page';

describe('MesesPage', () => {
  let component: MesesPage;
  let fixture: ComponentFixture<MesesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MesesPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MesesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
