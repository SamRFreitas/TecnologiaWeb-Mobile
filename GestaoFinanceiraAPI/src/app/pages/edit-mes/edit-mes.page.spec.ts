import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditMesPage } from './edit-mes.page';

describe('EditMesPage', () => {
  let component: EditMesPage;
  let fixture: ComponentFixture<EditMesPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditMesPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditMesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
