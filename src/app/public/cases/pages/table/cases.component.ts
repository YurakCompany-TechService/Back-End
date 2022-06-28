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
  templateUrl: './cases.component.html',
  styleUrls: ['./cases.component.css']
})
export class CasesTableComponent implements AfterViewInit {

  caseData: Case;
  technicianData: Technician;
  displayedColumns: string[] = ['date', 'technicianId', 'description', 'review', 'moreInfo'];
  dataSource: MatTableDataSource<Case>;

  @ViewChild(MatPaginator, {static: true})
  paginator!: MatPaginator;

  @ViewChild(MatSort)
  sort!: MatSort;

  constructor(private casesService: CasesService) {
    this.caseData = {} as Case;
    this.technicianData = {} as Technician;
    this.dataSource = new MatTableDataSource();
  }

  ngOnInit(): void {
    this.getAllCases();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  getAllCases() {
    this.casesService.getAll().subscribe((response: any) => {
      this.dataSource.data = response;
    });
  }

  getTechnician(technicianId: any) {
    return technicianId;
  }
}
