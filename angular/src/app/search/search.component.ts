import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { SearchServiceService } from '../search-service.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //search component data
  clubs = [];
  players = [];

  constructor(private route: ActivatedRoute, private router: Router, private _mainService: MainServiceService, private _searchService: SearchServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
    this._searchService.getClubs().subscribe(data=>this.clubs = data);
  }

  //navigation methods
  showSearchClub() {
    this.router.navigate(['searchclub'], {relativeTo: this.route});
  }

  showSearchPlayer() {
    this.router.navigate(['searchplayer'], {relativeTo: this.route});
  }

}
