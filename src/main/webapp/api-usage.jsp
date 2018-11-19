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
                    <a class="nav-link" href="api-usage.jsp">Usage
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



            <div class="row">


                <br/>
            </div>
            <!-- /.row -->

            <div>
                <h1>Settle Up API</h1>

                <div>
                    <h3>Overview</h3>
                    <p>
                        Utilizing the data resources provided by <a href="https://www.huduser.gov/portal/home.html">Housing and Urban Development (HUD)</a>, the Settle Up service
                        offers users a simple way to distill rental housing median costs in metropolitan areas from the myriad data provided by HUD.
                    </p>

                    <p>
                        This service allows searching of the comprehensive HUD database for median rent based on the number of rooms provided.  In addition,
                        Settle Up searches by activities in and around the metropolitan area.  The service will return hits within a range of $50 of the median rent based on the
                        number of rooms.
                    </p>

                    <p>
                        This easy to use service can return data in XML, JSON, and plain text.
                    </p>
                </div>

                <br />
                <h3>API Usage</h3>
                <h5>URI</h5>
                <p>
                    The URIs are set up in the pattern below:
                </p>
                <p>
                    <code>
                        http://18.216.201.147:8080/settleup/services/settleUpService/<i><strong>desired return data type</strong></i>/<i><strong>desired price</strong></i>/<i><strong>desired activity</strong></i>/<i><strong>desired number of rooms</strong></i>
                    </code>
                </p>
                <h5>Example</h5>
                <p>
                    <code>
                        http://18.216.201.147:8080/settleup/services/settleUpService/json/670/Sports/2
                    </code>
                </p>
                <p>In this example <strong>json</strong> is the <i><strong>desired return data type</strong></i>, <strong>$670</strong> is the <i><strong>desired price</strong></i>, <strong>Sports</strong> is the <i><strong>desired activity</strong></i>, and <strong>2</strong> is the <i><strong>desired number of rooms</strong></i>.</p>
                <div>
                    <h3>Returned Data</h3>
                    <p>Using the above example will yield the following output:</p>
                </div>
                <div>
                    <h5>JSON</h5>
                    <code>
                        [{"id":19,"city":"Calhoun County","county":"Calhoun County","activity":"Sports","errorMessage":null,"rent_0":485,"rent_1":545,"rent_2":718,"rent_3":941,"rent_4":1095,"stateAlpha":"AL","area":"Anniston-Oxford-Jacksonville, AL MSA"},{"id":357,"city":"Richland County","county":"Richland County","activity":"Sports","errorMessage":null,"rent_0":483,"rent_1":541,"rent_2":715,"rent_3":948,"rent_4":1113,"stateAlpha":"OH","area":"Mansfield, OH MSA"}]
                    </code>
                </div>
                <br />
                <br />
                <div>
                    <h5>XML</h5>
                    <xmp>
                        <searchResults>
                            <searchResults>
                                <activity>Sports</activity>
                                <area>Anniston-Oxford-Jacksonville, AL MSA</area>
                                <city>Calhoun County</city>
                                <county>Calhoun County</county>
                                <id>19</id>
                                <rent_0>485</rent_0>
                                <rent_1>545</rent_1>
                                <rent_2>718</rent_2>
                                <rent_3>941</rent_3>
                                <rent_4>1095</rent_4>
                                <stateAlpha>AL</stateAlpha>
                            </searchResults>
                            <searchResults>
                                <activity>Sports</activity>
                                <area>Mansfield, OH MSA</area>
                                <city>Richland County</city>
                                <county>Richland County</county>
                                <id>357</id>
                                <rent_0>483</rent_0>
                                <rent_1>541</rent_1>
                                <rent_2>715</rent_2>
                                <rent_3>948</rent_3>
                                <rent_4>1113</rent_4>
                                <stateAlpha>OH</stateAlpha>
                            </searchResults>
                        </searchResults>
                    </xmp>
                </div>
                <br />
                <br />
                <div>
                    <h5>Text</h5>
                    <code>
                        SettleUp(id=19, rent_0=485, rent_1=545, rent_2=718, rent_3=941, rent_4=1095, stateAlpha=AL, city=Calhoun County, county=Calhoun County, area=Anniston-Oxford-Jacksonville, AL MSA, activity=Sports, errorMessage=null), SettleUp(id=357, rent_0=483, rent_1=541, rent_2=715, rent_3=948, rent_4=1113, stateAlpha=OH, city=Richland County, county=Richland County, area=Mansfield, OH MSA, activity=Sports, errorMessage=null)
                    </code>
                </div>

            </div>

        </div>
        <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->
    <br />
    <br /><br />
    <br /><br />
    <br />
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

</body>

</html>

