<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        form {
    /* display: flex; */
    /* text-align: center; */
    border: 2px solid;
    padding: 4px;
}
    input{

        margin: 3px;
        padding: 8px;
        border: 2px solid black;
        width: 96%;
        

    }
    input:focus{
        box-shadow: 0 0 5px rgba(81, 203, 238, 1);
  /* padding: 3px 0px 3px 3px; */
  /* margin: 5px 1px 3px 0px; */
  border: 1px solid rgba(81, 203, 238, 1);

    }

    .container{

        background: 2px solid black;
        height: max-content;

    }
    .btn{
        border: 2px solid black;
        margin: 50px;
        margin-left: 46%;
        width: 100px;
        transition: transform .2s; /* Animation */
        background-color: white;

    }
    .btn:hover{
        transform: scale(1.5);
        cursor: pointer;
        text-decoration: underline;

    }
    h2{
        text-decoration: underline; 
        padding-left: 40%;
    }
    
    </style>
</head>
<body>
    

    <div class="container">
    
        <form action="UpdateServlet" method="post">
            <h2 >Customer_DETAILS</h2>

            <label for="customername"> Name</label><br>
            
            <input type="text" name="customername" placeholder="Name"><br>


            <label for="customerid"> customer_Id</label><br>
            
            <input type="text" name="customerid" placeholder="Id" value=><br>
            <label for="phone">phone no</label><br>

	<input type="text" name="phone" placeholder="Country Code"  value="+91" size="2"/>   
		  <br> 
            
           
            
            <label for="email">Email_id</label><br>
            <input type="text" name="email" placeholder="Email"><br>


            <label for="gender" >Gender:</label><br>

                <select id="gender" name="gender">
                 <option value="Male">Male</option>
                  <option value="Female">Female</option>
                  <option value="Other">Other</option>

                    </select>   
                    <br>


         <label for="adress">Address</label><br>
            <input type="text" name="adress" placeholder="adress" ><br>
            <label for="Nationality">Nationality</label><br>
            <input type="text" name="Nationality" placeholder="Email"><br>

            
            
            <h2 >Booking_DETAILS</h2>

            <label for="Bookingid">Booking_id </label><br>
            
            <input type="text" name="Bookingid" placeholder="Booking_id"><br>

            
            <label for="location"> Location</label><br>
            
            <input type="text" name="location" placeholder="Location"><br>


            <label for="locationid"> Location_Id</label><br>
            
            <input type="text" name="locationid" placeholder="Location_Id"><br>


            <label for="droneshotid">drone_shot_Id</label><br>
            <input type="text" name="droneshotid" placeholder="drone_shot_Id"><br>
            
            
            
            <button class="btn" type="submit">Update</button>
            
           
    



















            



        </form>


    </div>
</body>
</html>