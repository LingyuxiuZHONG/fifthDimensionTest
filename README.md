1. a GET method HelloWorld API that requires authentication
2. with username and password login API (could use username test and password 123456)

I use Postman to send GET and POST request

for GET test, need to add Header:

Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRlc3QifQ.0sQpkBQVfAU8FrmrW6Ka3edeNlKyOdSAZRj21iZLits

the token is generated in login API