import {async, ComponentFixture, TestBed} from "@angular/core/testing";
import {VegetablesDetailComponent} from "./vegetables-detail.component";
import {RouterTestingModule} from "@angular/router/testing";
import {FormsModule} from "@angular/forms";
import {ActivatedRoute, Data, Params, Router} from "@angular/router";
import {IVegetable, IVegetableResolved} from "../../model/vegetable";
import * as path from "path";
import {VegetableService} from "../../service/vegetable/vegetable.service";
import {of} from "rxjs";

describe('VegetablesDetailComponent', () => {
  let component : VegetablesDetailComponent;
  let fixture : ComponentFixture<VegetablesDetailComponent>;
  let mockVegetableService, mockRouter;
  let mockVegetable : IVegetableResolved;
  let vegetables: IVegetable[];

  beforeEach(async(() => {
    mockVegetable = {
      vegetable: {
        "vegetableId": "4002",
        "name": "Witloof",
        "type": "BLADGROENTEN",
        "info": "winter groenten",
        "imageUrl": "assets/vegetables/witloof"
      }
    };
    vegetables = [
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
    mockVegetableService = jasmine.createSpyObj(['getAllVegetables', 'addVegetable', 'updateVegetable', 'deleteVegetable']);
    mockVegetableService.getAllVegetables.and.returnValue(of(vegetables));
    mockRouter = jasmine.createSpyObj(['navigate']);
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, FormsModule],
      declarations: [VegetablesDetailComponent],
      providers: [
        {
          provide:ActivatedRoute,
          useValue: {
            data: {
              subscribe: (fn: (value: Data) => void) => fn({
                resolvedData: mockVegetable,
              }),
            },
            snapshot: {
              url : [
                {path: 'vegetables'},
                {path: '4002'},
                {path: 'edit'},
              ]
            },
            paramMap : {
              subscribe: (fn: (value: Params) => void) => fn({

              }),
            }
          }
        },
        {
          provide: Router,
          useValue: mockRouter
        },
        {
          provide: VegetableService,
          useValue: mockVegetableService
        },
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VegetablesDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });


  it('on create should be in edit mode', () => {
    expect(component).toBeTruthy();
    expect(component.isEditMode).toBe(true);
  });

  it('on toggleEdit should be in read mode',() => {
    component.toggleEditMode();
    expect(component.isEditMode).toBe(false);
  });

});
