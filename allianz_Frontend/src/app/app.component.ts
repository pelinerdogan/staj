import { Component } from '@angular/core';
import { Campaign } from './campaign';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'allianz';
 showHomeComponent = true;

 constructor(private router: Router, private route: ActivatedRoute) {
  this.router.events
    .pipe(filter((event) => event instanceof NavigationEnd))
    .subscribe(() => {
      this.showHomeComponent = this.route.snapshot.firstChild?.routeConfig?.path === '';
    });
}
}
