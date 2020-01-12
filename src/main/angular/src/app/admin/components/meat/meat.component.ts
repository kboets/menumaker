import { Component, OnInit } from '@angular/core';
import {IMeat} from "../../model/meat";

@Component({
  templateUrl: '../../meat-overview.html'
})
export class MeatComponent implements OnInit {

  meatList: IMeat[] = [];

  constructor() { }

  ngOnInit() {

  }

}
