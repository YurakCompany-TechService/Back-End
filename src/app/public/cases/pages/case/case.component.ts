import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatSortModule} from "@angular/material/sort";
import {MatTableDataSource} from '@angular/material/table';
import {Case} from "../../model/case";
import {CasesService} from "../../services/cases.service";
import {Technician} from "../../../../technicians/model/technician";

@Component({
  selector: 'cases-about',
  templateUrl: './case.component.html',
  styleUrls: ['./case.component.css']
})
export class CaseComponent implements AfterViewInit {

  caseData: Case;
  technicianData: Technician;

  constructor(private casesService: CasesService) {
    this.caseData = {} as Case;
    this.technicianData = {} as Technician;
  }

  ngOnInit(): void {}

  ngAfterViewInit() {}


  getTechnician(technicianId: any) {
    return technicianId;
  }
}
