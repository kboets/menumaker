import {async, TestBed} from '@angular/core/testing';

import { MeatService } from './meat.service';
import {HttpClientTestingModule, HttpTestingController, TestRequest} from "@angular/common/http/testing";
import {IMeat} from "../../model/meat";
import {VegetableService} from "../vegetable/vegetable.service";

describe('MeatService Test class', () => {
  let meatService : MeatService, httpTestingController : HttpTestingController;
  let meat: IMeat;
  let meatList: IMeat[];
  beforeEach(async(() => {
    meat = {
      "meatId": "1",
      "name": "Kipfilet",
      "type": "WIT",
      "imageUrl": "assets/images/meat/kipfilet.png",
      "meatOriginDtos": [
        {
          "meatOriginId": "2",
          "animal": "KIP"
        }
      ]
    };
    meatList = [
      {
        "meatId": "1",
        "name": "Kipfilet",
        "type": "WIT",
        "imageUrl": "assets/images/meat/Kipfilet.png",
        "meatOriginDtos": [
          {
            "meatOriginId": "2",
            "animal": "KIP"
          }
        ]
      },
      {
        "meatId": "2",
        "name": "Gehakt",
        "type": "ROOD",
        "imageUrl": "assets/images/meat/Gehakt.png",
        "meatOriginDtos": [
          {
            "meatOriginId": "1",
            "animal": "VARKEN"
          },
          {
            "meatOriginId": "3",
            "animal": "RUND"
          }
        ]
      }
    ];
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [MeatService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    meatService = TestBed.get(MeatService);
    httpTestingController = TestBed.get(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    const service: MeatService = TestBed.get(MeatService);
    expect(service).toBeTruthy();
  });

  it('should return 2 elements when calling getAllMeats()', () => {
    meatService.getAllMeat().subscribe((data:IMeat[]) =>{
      expect(data.length).toBe(2);
    });
    let meatRequest : TestRequest = httpTestingController.expectOne('/menumaker/meat');
    expect(meatRequest.request.method).toEqual('GET');
    meatRequest.flush(meatList);
  });
});
