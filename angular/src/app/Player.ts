export class Player {
    playerid: number
    age: number
    assists: number
    goals: number
    position: string
    imgurl: string
    name: string
    surname: string
    foot: string
    height: number
    clubid: number
    img: any

    constructor(playerid: number, age: number, assists: number, goals: number, position: string, imgurl: string, name: string,surname: string, foot: string, height: number, clubid: number, img: any) {
        this.playerid = playerid
        this.age = age
        this.assists = assists
        this.goals = goals
        this.position = position
        this.imgurl = imgurl
        this.name = name
        this.surname = surname
        this.foot = foot
        this.height = height
        this.clubid = clubid
        this.img = img
    }

}