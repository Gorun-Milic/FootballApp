import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { PlayerServiceService } from '../player-service.service';
import { Imagedto } from '../Imagedto';

@Component({
  selector: 'app-club-profile',
  templateUrl: './club-profile.component.html',
  styleUrls: ['./club-profile.component.css']
})
export class ClubProfileComponent implements OnInit {

  //session data
  private id = 0;
  public club = new Club(undefined, '', '', '', undefined, undefined, undefined);

  //other data
  public players = [];
  public stringArray;
  public message;

  //photo data
  public selectedFile;
  //public event1;
  imgURL: any;
  convertedImage = undefined;

  constructor(private _playerService: PlayerServiceService, private _mainService: MainServiceService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    //initialising session data
    this.id = this._mainService.getClubId();
    this.club = this._mainService.getClub();

    //getting all players from club
    this.initPlayers();

    //slika
    if (this.club.img!=undefined) {
      this.convertedImage = 'data:image/jpeg;base64,' + this.club.img;
    } 
  }

  initPlayers() {
    this._mainService.getPlayers(this.id).subscribe(data=>{this.players = data});
  }

  removePlayer(playerid: number) {
    this._playerService.removePlayer(playerid).subscribe(data=>{this.message = data;                            
                                                        this.refreshComponent();},
                                                        error=>{
                                                        this.refreshComponent()});
                                                        
  }

  editPlayer(playerid: number) {
    this.router.navigate(['/editplayer', playerid]);
  }

  editClub() {
    this.router.navigate(['/editclub']);
  }

  //adding photo mehods
  public  onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    // Below part is used to display the selected image
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
  };

 }


  // This part is for uploading
  uploadPhoto() {
    const uploadData = new FormData();
    uploadData.append('myFile', this.selectedFile, this.id + "");

    //let imgDto = new Imagedto(uploadData, this.id);
    this._mainService.uploadPhoto(uploadData).subscribe(
      data => {this._mainService.setClub(data);
              this._mainService.setClubId(data.clubid);
              this.refreshComponent();
            },
      err => {console.log('Error Occured duringng saving: ' + err);
              this.refreshComponent();}
   );
  }

  showPlayer(playerid: number) {
    this.router.navigate(['/watchplayer', playerid]);
  }

  refreshComponent() {
    this.router.navigateByUrl('/RefreshComponent', { skipLocationChange: true }).then(() => {
      this.router.navigate(['/club']);
  });
  }
  

}
