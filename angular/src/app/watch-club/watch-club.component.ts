import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { RememberServiceService } from '../remember-service.service';

@Component({
  selector: 'app-watch-club',
  templateUrl: './watch-club.component.html',
  styleUrls: ['./watch-club.component.css']
})
export class WatchClubComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //other data
  public clubid;
  public watchClub = new Club(2, 'None', 'None', '', 2, 2, undefined);
  public players = [];

  //img data
  public base64Data;
  public convertedImage;

  constructor(private route: ActivatedRoute, private _rememberService: RememberServiceService ,private _mainService: MainServiceService) { }

  ngOnInit() {
    //init session data
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();

    //geting params from navigation
    this.route.paramMap.subscribe((params: ParamMap)=> {
      this.clubid = parseInt(params.get('clubid'))});

    //getting player      
    this._rememberService.getClub(this.clubid).subscribe(data=>{this.watchClub = data
                                                                this.base64Data = this.watchClub.img;
                                                                if (this.base64Data!=undefined) {
                                                                  this.convertedImage = 'data:image/jpeg;base64,' + this.base64Data;
                                                                }});

    //getting all players from club
    this._mainService.getPlayers(this.clubid).subscribe(data=>{this.players = data});

    //slika
    
  }

}
