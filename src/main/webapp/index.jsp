<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Settle Up</title>

    <!-- Bootstrap core CSS -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <script src="scripts/activities.js" rel="script"></script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="/settleup/">Settle Up! Why Settle Down?</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="api-usage.jsp">API Usage
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">

            <h1 class="my-4">Settle<img id="logo" src="images/logo.jpeg" alt="logo"></h1>



        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        <img class="d-block img-fluid" src="images/losAngeles.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="images/miami.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block img-fluid" src="images/chicago.jpg" alt="Third slide">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <div class="row">

                <form class="form-horizontal" action="/settleup/responseServlet" method="POST">

                    <c:if test="${form == \"empty\"}">
                        <div class="alert alert-danger">
                            <h6>Please enter rent amount.</h6>
                        </div>
                    </c:if>

                    <div class="form-group">
                        <label for="rent">Monthly Rent</label>
                        <input type="text" class="form-control" name="monthlyRent" id="rent" placeholder="rent amount">
                    </div>

                    <div class="form-group">
                        <label for="bedrooms">Number of Bedrooms:</label>
                        <select class="form-control" id="bedrooms" name="numberOfBedrooms">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>


                    <div class="form-group">
                        <label for="returnType">Your Favorite Activity</label>
                        <select class="form-control" id="activity" name="activity">
                            <!-- dynamically generated with jquery and service -->
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="returnType">Consume with:</label>
                        <select class="form-control" id="returnType" name="returnType">
                            <option value="json">Json</option>
                            <option value="xml">XML</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
                <br/>
            </div>
            <!-- /.row -->

            <div id="table_response">

                <table class="table">
                    <thead>
                        <th>Metro Area</th>
                        <th>Number of Rooms</th>
                        <th>Requested Price</th>
                        <th>Activities</th>
                    </thead>
                    <tbody>
                <c:forEach var="result" items="${results}">
                     <c:choose>
                        <c:when test="${empty result.errorMessage}">
                        <tr>
                        <td>${result.area}</td>
                        <td>${bedrooms}</td>
                        <td>${price}</td>
                        <td>${result.activity}</td>
                        </tr>
                        </c:when>
                        <c:when test="${not empty result.errorMessage}">
                            </table>
                            <p>${result.errorMessage}</p>
                        </c:when>
                    </c:choose>
                </c:forEach>
                </tbody>
                </table>
            </div>

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white"></p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="static/jquery/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="application/javascript"></script>
</body>

</html>

