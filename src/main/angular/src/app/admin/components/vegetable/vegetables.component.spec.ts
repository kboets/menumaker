import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VegetablesComponent } from './vegetables.component';
import {ActivatedRoute, Data} from "@angular/router";
import {RouterTestingModule} from "@angular/router/testing";
import {of} from "rxjs";
import {IVegetable} from "../../model/vegetable";
import {FormsModule} from "@angular/forms";

describe('VegetablesComponent', () => {
  let component: VegetablesComponent;
  let fixture: ComponentFixture<VegetablesComponent>;
  let vegetables: IVegetable[] = [
    {
      "vegetableId": "4002",
      "name": "Witloof",
      "type": "BLADGROENTEN",
      "info": "winter groenten",
      "imageUrl": "assets/vegetables/witloof"
    },
    {
      "vegetableId": "4003",
      "name": "Spinazie",
      "type": "BLADGROENTEN",
      "info": "super groenten",
      "imageUrl": "assets/vegetables/spinazie"
    },
    {
      "vegetableId": "4004",
      "name": "Bloemkool",
      "type": "KOOLGROENTEN",
      "info": "allround groenten",
      "imageUrl": "assets/vegetables/bloemkool"
    }
  ];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, FormsModule],
      declarations: [VegetablesComponent],
      providers: [
        {
          provide: ActivatedRoute,
          useValue: {
            snapshot: {
              data: {
                vegetables:vegetables
              }
            }
          }
        }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VegetablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have 3 vegetables keys', () => {
    expect(component.vegetablesKeys.length).toBe(3);
  });

  it('on changeType return only filtered vegetables', () => {
    component.changeType('BLADGROENTEN');
    expect(component.filteredVegetables.length).toBe(2);
  });

  it('on changeType with type Alles should not filter vegetables', () => {
    component.changeType('Alles');
    expect(component.filteredVegetables.length).toBe(3);
  });

});
