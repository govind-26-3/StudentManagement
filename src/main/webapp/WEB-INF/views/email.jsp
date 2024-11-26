<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Email</title>
<style>
    /* Container styling */
    .container {
        max-width: 600px;
        margin: 50px auto;
        padding: 20px;
        border: 1px solid #ddd;
        border-radius: 8px;
        background-color: #f9f9f9;
    }

    /* Heading styling */
    h1 {
        text-align: center;
        margin-bottom: 20px;
        font-family: Arial, sans-serif;
        color: #333;
    }

    /* Label styling */
    .form-label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        font-family: Arial, sans-serif;
    }

    /* Input and Textarea styling */
    .form-control {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }

    /* Button styling */
    .btn-primary {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    
    .btn-primary:hover {
        background-color: #0056b3;
    }

    /* Link styling */
    a {
        display: inline-block;
        margin-top: 10px;
        color: #007bff;
        text-decoration: none;
    }
    
    a:hover {
        text-decoration: none;
    }
</style>
</head>
<body>

    <div class="container">
        <h1>Email Page</h1>
        <form action="send" method="post">

            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">To Email</label>
                <input type="email" name="to" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
            </div>

            <div class="mb-3">
                <label for="exampleFormControlInput2" class="form-label">Subject</label>
                <input type="text" name="subject" class="form-control" id="exampleFormControlInput2" placeholder="Enter subject">
            </div>

            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Body</label>
                <textarea class="form-control" name="body" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>
            
            <button type="submit" class="btn-primary">Send</button>
            <br>
            <a href="home">Home Page</a>
        
        </form>
    </div>

</body>
</html>
