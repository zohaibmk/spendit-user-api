# spendit-user-api
Spendit User API

## API End-Points:-
- Login: /api/login
- Logout: /api/users/logout
- Create a new user: /api/users
- Reset Password: /api/users/{username}/reset-password
- Forget Password: /api/users/{email}/forget-password
- Database View: /h2-ui/login.jsp

## Steps to use the API:
- Create a new User with:
	- username (min 4, max 10 alpha-numeric characters only).
	- password (min 6 characters).
	- email (format: abc@abc.com).
- Login User: 
	- A valid username.
	- A valid password.
- Logout User: 
	- Login credentials (login is required to logout user).
	- Username of the loggedIn user.
- Reset-Password:
	- Login credentials (login is required to logout user).
	- Username of the loggedIn user.
	- New Password (min 6 characters, only the password value should be passed in body).
- Forget-Password:
	- A valid email.
- To View the Users in Database:
	- Go to /h2-ui/login.jsp
	- url: jdbc:h2:mem:spendit-api-db
	- username: zm
	- password: leave the password empty.
	
