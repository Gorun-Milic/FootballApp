import { League } from './League'

export class Club {
    clubid: number
    imgurl: string
    name: string
    password: string
    value: number
    league: League
    img: any

    constructor(clubid: number, imgurl: string, name: string, password: string, value: number, league, img) {
        this.clubid = clubid
        this.imgurl = imgurl
        this.name = name
        this.password = password
        this.value = value
        this.league = league
        this.img = img
    }
}