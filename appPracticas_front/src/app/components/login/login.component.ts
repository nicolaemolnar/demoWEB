import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = "";
  password = "";

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onSubmit(): void{
    // Call to backend and validate user and alert with result
    const req = this.httpClient.post('http://192.168.56.10:8080/users/login', {name: this.username, password: this.password});
    console.log(this.username, this.password);
    req.subscribe((data) => {
      if (data) {
        alert("Login success!!");
      }else{
        alert("Credentials are incorrect...");
      }
    });
  }
}
