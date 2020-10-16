<!DOCTYPE html>
<html>
    <head>
        <%
            if (session.getAttribute("userfullname") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Store</title>
        <meta name="description" content="">
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet"
              href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Fontastic Custom icon font-->
        <link rel="stylesheet" href="css/fontastic.css">
        <!-- Google fonts - Poppins -->
        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.blue.css"
              id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.ico">
        <!-- Tweaks for older IEs-->
        <!--[if lt IE 9]>
                <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body onload="load()">
        <div class="page">
            <!-- Main Navbar-->
            <header class="header">
                <nav class="navbar">
                    <!-- Search Box-->
                    <div class="search-box">
                        <button class="dismiss">
                            <i class="icon-close"></i>
                        </button>
                        <form id="searchForm" action="#" role="search">
                            <input type="search" placeholder="What are you looking for..."
                                   class="form-control">
                        </form>
                    </div>
                    <div class="container-fluid">
                        <div
                            class="navbar-holder d-flex align-items-center justify-content-between">
                            <!-- Navbar Header-->
                            <div class="navbar-header">
                                <!-- Navbar Brand -->
                                <a href="index.jsp"
                                   class="navbar-brand d-none d-sm-inline-block">
                                    <div class="brand-text d-none d-lg-inline-block">
                                        <span>Arunonanda </span><strong> Supermarket</strong>
                                    </div>
                                    <div class="brand-text d-none d-sm-inline-block d-lg-none">
                                        <strong>AS</strong>
                                    </div>
                                </a>
                                <!-- Toggle Button-->
                                <a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
                            </div>
                            <!-- Navbar Menu -->
                            <ul
                                class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">

                                <li class="nav-item"><a href="logout.jsp"
                                                        class="nav-link logout"> <span class="d-none d-sm-inline">Logout</span><i
                                            class="fa fa-sign-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <div class="page-content d-flex align-items-stretch">
                <!-- Side Navbar -->
                <nav class="side-navbar">
                    <!-- Sidebar Header-->
                    <div class="sidebar-header d-flex align-items-center">
                        <div class="avatar">
                            <img src="img/user.png" alt="..." class="img-fluid rounded-circle">
                        </div>
                        <div class="title">
                            <h1 class="h4">${userfullname}</h1>
                            <p>${usertype}</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus-->
                    <span class="heading">Main</span>
                    <ul class="list-unstyled">

                        <li><a href="invoice.jsp"><i class="fa fa-file-text-o"></i>Invoice</a></li>
                        <li><a href="customer.jsp"><i class="fa fa-user-o"></i>Customer</a></li>
                        <li><a href="item.jsp"><i class="fa fa-cube"></i>Item</a></li>
                        <li><a href="stock.jsp"><i class="fa fa-cubes"></i>Stock</a></li>
                        <li><a href="grn.jsp"><i class="fa fa-file-text"></i>GRN</a></li>
                        <li><a href="supplier.jsp"><i class="fa fa-users"></i>Supplier</a></li>
                        <li><a href="delivery.jsp"><i class="fa fa-cab"></i>Delivery</a></li>
                        <li class="active"><a href="#employeetab" aria-expanded="false"
                                              data-toggle="collapse"> <i class="fa fa-user-circle-o"></i>Employee Management
                            </a>
                            <ul id="employeetab" class="collapse list-unstyled show ">
                                <li><a href="attendance.jsp">Attendance</a></li>
                                <li><a href="salary.jsp">Salary Structure</a></li>
                                <li class="active"><a href="employee.jsp">Employee</a></li>
                            </ul></li>




                        <li><a href="user.jsp"><i class="fa fa-cab"></i>User Management</a></li>
                        <li><a href="logout.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">Online Store</h2>
                        </div>
                    </header>
                    <!-- Breadcrumb-->
                    <div class="breadcrumb-holder container-fluid">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active">Forms</li>
                        </ul>
                    </div>
                    <!-- Forms Section-->
                    <section class="forms">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">employee</h3>
                                        </div>
                                        <div class="card-body">
                                            <form class="form-horizontal"  id="form">
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="emp_id" type="hidden"	value="0" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Full Name</label>
                                                    <div class="col-sm-9">
                                                        <input id="full_name" type="text" onkeypress="validateName()" placeholder="full name" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Address</label>
                                                    <div class="col-sm-9">
                                                        <input id="address" type="text"	placeholder="address" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Email</label>
                                                    <div class="col-sm-9">
                                                        <input id="email" type="text"	placeholder="email" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Contact number</label>
                                                    <div class="col-sm-9">
                                                        <input id="contact_number" type="text" onkeypress="onClickValidationContactNumber()"	placeholder="contact number" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">Designation</label>
                                                    <div class="col-sm-9">
                                                        <input id="designation" type="text"	placeholder="designation" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9">
                                                        <input id="date_time" type="hidden"	value="2020" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9 offset-sm-3">
                                                        <input onclick="save()" type="button" value="Save" class="btn btn-primary">
                                                        <input onclick="update()" type="button" value="Update" class="btn btn-primary">
                                                        <input onclick="delet()" type="button" value="Delete" class="btn btn-primary">
                                                        <input onclick="generateReport()" type="button" value="Report" class="btn btn-secondary">
                                                        <input type="reset" value="Reset" class="btn btn-primary">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="card" id="report">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">History</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-hover" id="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>emp id</th>
                                                            <th>full name</th>
                                                            <th>address</th>
                                                            <th>email</th>
                                                            <th>contact number</th>
                                                            <th>designation</th>
                                                            <th>date time</th>
                                                        </tr>
                                                    </thead>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- Page Footer-->
                    <footer class="main-footer">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-sm-6">
                                    <p>SLIIT &copy; 2017-2020</p>
                                </div>
                                <div class="col-sm-6 text-right">
                                    <p>
                                        Design by <a href="#" class="external">SLIIT</a>
                                    </p>
                                    <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                                </div>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
        <!-- JavaScript files-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/popper.js/umd/popper.min.js">

        </script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/jquery.cookie/jquery.cookie.js">

        </script>
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
        <!-- Main File-->
        <script src="js/front.js"></script>

        <script type="text/javascript">
                                                            function Export() {
                                                                html2canvas(document.getElementById('report'), {
                                                                    onrendered: function (canvas) {
                                                                        var data = canvas.toDataURL();
                                                                        var docDefinition = {
                                                                            content: [{

                                                                                    image: data,
                                                                                    width: 500
                                                                                }]
                                                                        };
                                                                        pdfMake.createPdf(docDefinition).download("Report.pdf");
                                                                    }
                                                                });
                                                            }
                                                            $(document).ready(function () {
                                                                $("#search_table").on("keyup", function () {
                                                                    var value = $(this).val().toLowerCase();
                                                                    $("#table tr").filter(function () {
                                                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                                                    });
                                                                });
                                                            });
        </script>
        <script src="Ajax/ajax.js" type="text/javascript"></script>
        <script src="Ajax/EmployeeJS.js" type="text/javascript"></script>
        <script src="Ajax/Validations.js" type="text/javascript"></script>
    </body>
</html>