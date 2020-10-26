export class SearchplayersDTO {
    name: string
    surname: string
    position: string
    age: number
    foot: string
    height: number

    constructor(name: string, surname: string, position: string, age: number, foot: string, height: number) {
        this.name = name
        this.surname = surname
        this.position = position
        this.age = age
        this.foot = foot
        this.height = height
    }
}