import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpStatusCode } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username = "";
  password = "";

  constructor(private httpClient: HttpClient, private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit(): void{
    // Call to backend and validate user and alert with result
    const req = this.httpClient.post('http://192.168.56.10:8080/users', {name: this.username, password: this.password}, {observe: 'response'});
    console.log(this.username, this.password);
    req.subscribe((res) => {
      console.log(res.status);
      if(res.status == HttpStatusCode.Created){
        // redirect to login
        this.router.navigate(['/login']);
      }else{
        alert("Error creating user, check the data and try again");
      }
    });
    
  }

}
