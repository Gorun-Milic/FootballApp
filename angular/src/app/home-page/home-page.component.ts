import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MainServiceService } from '../main-service.service'; 
import { Club } from '../Club';
import { Clubdto } from '../Clubdto';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  public registerClub = new Clubdto(undefined, '', undefined, undefined, undefined, '', '');
  public loginClub = new Clubdto(undefined, '', undefined, undefined, undefined, '', '');

  leagues = [];

  

  constructor(private router: Router, private _mainService: MainServiceService) { }

  ngOnInit() {
    this._mainService.getLeagues().subscribe(data=>this.leagues = data);
  }

  register() {
    this._mainService.register(this.registerClub);
  }

  login() {
    this._mainService.login(this.loginClub);
  }

}
