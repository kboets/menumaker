import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router, UrlSegment} from "@angular/router";
import {IVegetable, IVegetableResolved} from "../../model/vegetable";
import {FormBuilder, FormGroup, NgForm, Validators} from "@angular/forms";
import * as _ from 'underscore';
import {VegetableService} from "../../service/vegetable/vegetable.service";

@Component({
  templateUrl: '../../vegetables-detail.html',
  styleUrls:['../../vegetables-detail.css']
})
export class VegetablesDetailComponent implements OnInit {

  vegetables: IVegetable[] = [];
  vegetable: IVegetable;
  vegetablesKeys: string [] = [];
  paramValue : string;
  isEditMode:boolean = false;
  errorMessage: string;

  constructor(private route: ActivatedRoute, private router: Router, private vegetableService: VegetableService) { }

  getVegetable(vegetable : IVegetable) {
    console.log("in the getVegetable " +vegetable);
    this.vegetable = vegetable;

    if(this.vegetable === null) {
      this.vegetable = this.initVegetable();
      this.setIsEditMode("edit");
    }
  }

  saveVegetable(vegetableForm: NgForm) {
    console.log(vegetableForm.submitted);
    let vegetableId = parseInt(this.vegetable.vegetableId);
    if(vegetableId === 0) {
      console.log(vegetableId);
      this.vegetableService.addVegetable(this.vegetable).subscribe(
        (result: IVegetable) => console.log(result),
        (error: any) => console.log(error)
      );
    } else {
      this.vegetableService.updateVegetable(this.vegetable).subscribe(

      )
    }
    this.router.navigate(['/vegetables'])
  }

  deleteVegetable() {
    let vegetableId = parseInt(this.vegetable.vegetableId);
    this.vegetableService.deleteVegetable(vegetableId).subscribe(
      (result: void) => console.log("successful deleted"),
      (error: any) => console.log(error)
    );
    this.router.navigate(['/vegetables'])
  }

  ngOnInit() {
    this.route.data.subscribe(
      data => {
        const resolvedData: IVegetableResolved = data['resolvedData'];
        this.errorMessage = resolvedData.error;
        this.getVegetable(resolvedData.vegetable);
      }
    );

    this.route.paramMap.subscribe(
      params => {
        this.paramValue= this.route.snapshot.url[2].path;
      }
    );
    this.setIsEditMode(this.paramValue);

    this.vegetableService.getAllVegetables().subscribe(
      (result:IVegetable[]) => this.initVegetablesKeys(result),
      (error: any) => console.log(error)
    );
  }

  toggleEditMode() {
    if(this.getIsEditMode()) {
      this.isEditMode = false;
    } else {
      this.isEditMode = true;
    }
  }

  getIsEditMode():boolean {
    return this.isEditMode;
  }

  setIsEditMode(value:string) {
    if(value === 'edit') {
      this.isEditMode = true;
    }
  }

  private initVegetable() {
    return  {
      vegetableId: "0",
      type:"",
      name:"",
      info:"",
      imageUrl:""
    }
  }

  initVegetablesKeys(vegetablesList:IVegetable[]) {
    this.vegetables = vegetablesList;
    console.log("vegetables length "+this.vegetables.length);
    let vegetablesByType = _.groupBy(this.vegetables,"type");
    this.vegetablesKeys = _.allKeys(vegetablesByType);
  }

}
