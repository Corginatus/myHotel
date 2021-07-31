<html>
<body>
<form action="/admin/hotel_add" method="post">

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Hotel name</label>
        <input type="text" class="form-control" name="hotelName" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">you can't change username after registration</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Count of rooms</label>
        <input type="text" class="form-control" name="rooms" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Owner name</label>
        <input type="text" class="form-control" name="ownerName" id="exampleInputEmail2" aria-describedby="emailHelp">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>