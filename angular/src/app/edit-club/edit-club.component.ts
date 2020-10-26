import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';

@Component({
  selector: 'app-edit-club',
  templateUrl: './edit-club.component.html',
  styleUrls: ['./edit-club.component.css']
})
export class EditClubComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //other data
  leagues = [];


  constructor(private _mainService: MainServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();

    this._mainService.getLeagues().subscribe(data=>this.leagues = data);
  }

  editClub() {
    this._mainService.editClub(this.club);
  }

}
