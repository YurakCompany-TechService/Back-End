import { ComponentFixture, TestBed } from '@angular/core/testing';

import {DialogSubscriptionComponent} from "./dialogSubscription.component";

describe('BasicModalComponent', () => {
  let component: DialogSubscriptionComponent;
  let fixture: ComponentFixture<DialogSubscriptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogSubscriptionComponent ]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogSubscriptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
