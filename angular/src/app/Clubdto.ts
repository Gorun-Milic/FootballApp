export class Clubdto {
    clubid: number
    name: string
    value: number
    leagueid: number
    stadiumid: number
    imgUrl: string
    password: string

    constructor(
        clubid: number,
        name: string, 
        value: number, 
        leagueid: number, 
        stadiumid: number, 
        imgUrl: string, 
        password: string,
    ){
        this.clubid = clubid
        this.name = name
        this.value = value
        this.leagueid = leagueid
        this.stadiumid = stadiumid
        this.imgUrl = imgUrl
        this.password = password
    };
}