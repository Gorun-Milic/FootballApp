import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  constructor(private route: ActivatedRoute, private router: Router, private _mainService: MainServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
  }


}
