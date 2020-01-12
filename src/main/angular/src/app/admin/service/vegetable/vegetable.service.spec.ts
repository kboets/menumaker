import {async, TestBed} from '@angular/core/testing';

import {VegetableService} from './vegetable.service';
import {HttpClientTestingModule, HttpTestingController, TestRequest} from "@angular/common/http/testing";
import {IVegetable} from "../../model/vegetable";
import {HttpErrorResponse} from "@angular/common/http";
import {of} from "rxjs";
import {IngredientError} from "../../model/ingredientError";

describe('VegetableService Test class', () => {
  let vegetableService: VegetableService, httpTestingController:HttpTestingController;
  let vegetable: IVegetable;
  let vegetables: IVegetable[];
  beforeEach(async(() => {
    vegetable = {
      "vegetableId": "4004",
      "name": "Bloemkool",
      "type": "KOOLGROENTEN",
      "info": "allround groenten",
      "imageUrl": "assets/vegetables/bloemkool"
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
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [VegetableService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    vegetableService = TestBed.get(VegetableService);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should return 3 vegetables when calling getAllVegetables',() => {
    vegetableService.getAllVegetables().subscribe((data:IVegetable[])=>{
      expect(data.length).toBe(3);
    });

    let vegetablesRequest: TestRequest = httpTestingController.expectOne('/menumaker/vegetable')
    expect(vegetablesRequest.request.method).toEqual('GET');
    vegetablesRequest.flush(vegetables);
  });

  it('should return IngredientError when calling getAllVegetables', () => {
     vegetableService.getAllVegetables().subscribe(
       (data:IVegetable[])=> expect(data.length).toEqual(0),
       (error:IngredientError) => {
         expect(error.userFriendlyMessage).toBe("Er liep iets fout bij het ophalen van de data");
         expect(error.errorNumber).toBe(500)
       }
       );
    let vegetablesRequest: TestRequest = httpTestingController.expectOne('/menumaker/vegetable');
    expect(vegetablesRequest.request.method).toEqual('GET');
    vegetablesRequest.flush('error', {
      status:500,
      statusText: 'Unexpected server error'
    });
  });

  it('should return one vegetable when calling getVegetableById with existing id', ()=> {
    let id: number = 4004;
    vegetableService.getVegetableById(id).subscribe((data:IVegetable)=>{
      expect(data.vegetableId).toBe(id.toString());
    });

    let vegetablesRequest: TestRequest = httpTestingController.expectOne(`/menumaker/vegetable/${id}`)
    expect(vegetablesRequest.request.method).toEqual('GET');
    vegetablesRequest.flush(vegetable);
    httpTestingController.verify();
  });


  it('should return error when calling getVegetableById with non existing id', ()=> {
    let id: number = 4018;
    vegetableService.getVegetableById(id).subscribe(
      (data:IVegetable)=> expect(data.vegetableId).toBe(undefined),
      (error: HttpErrorResponse)=> {expect(error).toBeTruthy()}
    );

    let vegetablesRequest: TestRequest = httpTestingController.expectOne(`/menumaker/vegetable/${id}`)
    expect(vegetablesRequest.request.method).toEqual('GET');

    vegetablesRequest.flush(of(HttpErrorResponse));
    httpTestingController.verify();
  });

  it('should addVegetable', ()=>{
      vegetableService.addVegetable(vegetable).subscribe((data:IVegetable) => {
        expect(data.name).toBe("Bloemkool")
      });
      let vegetablesRequest: TestRequest = httpTestingController.expectOne(`/menumaker/vegetable`)
      expect(vegetablesRequest.request.method).toEqual('POST');
      vegetablesRequest.flush(vegetable);
  });


});
