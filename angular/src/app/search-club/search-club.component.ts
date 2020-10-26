import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { SearchServiceService } from '../search-service.service';
import { Router } from '@angular/router';
import { SearchclubDTO } from '../SearchclubDTO';

@Component({
  selector: 'app-search-club',
  templateUrl: './search-club.component.html',
  styleUrls: ['./search-club.component.css']
})
export class SearchClubComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //searched data
  searchClub = new SearchclubDTO('', undefined, undefined);
  clubs = [];
  leagues = [];

  constructor(private router: Router, private _mainService: MainServiceService, private _searchService: SearchServiceService) { }

  ngOnInit() {
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();
    this._searchService.getClubs().subscribe(data=>{this.clubs = data});
    this._mainService.getLeagues().subscribe(data=>this.leagues = data);
  }

  showClub(clubid: number) {
    this.router.navigate(['/watchclub', clubid]);
  }

  searchClubs() {
    this._searchService.searchClubs(this.searchClub).subscribe(data=>{this.clubs = data});
  }


}
