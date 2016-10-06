import {Component} from "@angular/core";

class CarouselImage {
    constructor(public image: string,
                public text: string) {
    }
}

@Component({
    selector: 'main-carousel',
    templateUrl: 'main-carousel.html',
    styleUrls: ['main-carousel.scss']
})
export class MainCarousel {
    public slides: Array<CarouselImage> = [];
    public myInterval: number = 5000;
    public noWrapSlides: boolean = false;

    public constructor() {
        for (let i = 0; i < 4; i++) {
            this.addSlide();
        }
    }

    public addSlide(): void {
        let newWidth = 600 + this.slides.length + 1;
        let img = new CarouselImage(`//placekitten.com/${newWidth}/300`,
            `${['More', 'Extra', 'Lots of', 'Surplus'][this.slides.length % 4]}
      ${['Cats', 'Kittys', 'Felines', 'Cutes'][this.slides.length % 4]}`);
        this.slides.push(img);
    }
}