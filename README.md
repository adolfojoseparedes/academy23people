# academy23people
The Academy23People API Rest allows you to maintain a list of courses and students using spring according to the following definition:<br/>
course:<br/>
■ name<br/>
■ code (max 4 chars)<br/>
<br/>
▹ student:<br/>
■ rut (valid rut with verification digit)<br/>
■ name<br/>
■ lastName<br/>
■ age ( > 18)<br/>
■ course<br/>
<br/>
The Academy23People API validates the json required for the creation of courses and students.<br/>
The Academy23People API requires a JWT validation token using Spring Security.<br/>
<br/>
The Academy23People API Rest has the following guidelines:<br/>
▸ Use the verbs, headers and states of the HTTP protocol to create services<br/>
▹ Verbs<br/>
■ GET to read or list information about a resource<br/>
■ POST to create resources or execute processes<br/>
■ PUT to update resources<br/>
■ DELETE to remove resources<br/>
▹ Headers<br/>
■ Content-Type<br/>
■ Authorization<br/>
■ Accept<br/>
▹ States<br/>
■ 200 -> OK when obtaining a resource, updating and deleting it.<br/>
■ 201 -> Created<br/>
■ 4xx -> Client Errors (404 when not finding a resource)<br/>
■ 5xx -> Server Errors<br/>
<br/>
The Academy23People API Rest for courses and students have the following guidelines:<br/>
Courses:<br/>
▸ GET /courses -> returns a paged list of existing courses<br/>
▸ GET /courses/all -> returns complete list of existing courses<br/>
▸ GET /courses/:id -> returns the course corresponding to the delivered id. If it does not exist a course with :id then must return the status 404<br/>
▸ POST /courses + json -> Allows to create a course with the data provided in the json. Returns status 201 if created successfully If the data is invalid you must return status 400.<br/>
▸ PUT /courses/:id + json -> Update a course with the delivered id and the included in the json.<br/>
▸ DELETE /courses/:id -> Deletes a course with the delivered id and returns status 200. If the course does not exist it returns status 404.<br/>
<br/>
Student:<br/>
▸ GET /students -> returns a paged list of existing students.<br/>
▸ GET /students/all -> returns complete list of existing students.<br/>
▸ GET /students/:id -> returns the student corresponding to the delivered id. If it does not exist a course with :id then must return the status 404.<br/>
▸ POST /students + json -> Allows to create a student with the data provided in the json. Returns status 201 if created successfully. If the data is invalid you must return status 400.<br/>
▸ PUT /students/:id + json -> Update a student with the delivered id and the included in the json.<br/>
▸ DELETE /students/:id -> Deletes a student with the delivered id and returns status 200 If the course does not exist it returns status 404.<br/>
