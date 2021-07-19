<jsp:include page="header_worker.jsp"/>
<html>
<body>
<form action="/worker/profile" th:object="${worker}" enctype="multipart/form-data" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Your name</label>
        <input type="email" class="form-control" name="name" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Your surname</label>
        <input type="email" class="form-control" name="surname" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Your experience</label>
        <input type="email" class="form-control" name="ex" id="exampleInputEmail2">
    </div>
    <div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="sex" id="MAN" checked value="MAN">
            <label class="form-check-label" for="MAN">
                Man
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="sex" id="FEMALE" checked value="FEMALE">
            <label class="form-check-label" for="FEMALE">
                Female
            </label>
        </div>
    </div>
    <div>
        <select class="form-select form-select-sm" aria-label=".form-select-sm example" name="timeType">
            <option selected>Open this select menu</option>
            <option value="FULLTIME">FULLTIME</option>
            <option value="PARTTIME">PARTTIME</option>
            <option value="FIXED">FIXED</option>
            <option value="FLEXIBLE">FIXED</option>
            <option value="ROTATING">FIXED</option>
        </select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>