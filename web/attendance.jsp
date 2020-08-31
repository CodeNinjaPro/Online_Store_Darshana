<!DOCTYPE html>
<html>
    <head>
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
        <link rel="stylesheet" href="css/style.default.css"
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
                                <a href="index.html"
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
                            <h1 class="h4">Roshan Withanage</h1>
                            <p>Developer</p>
                        </div>
                    </div>
                    <!-- Sidebar Navidation Menus-->
                    <span class="heading">Main</span>
                    <ul class="list-unstyled">
                        <li class="active"><a href="#chemicals" aria-expanded="false"
                                              data-toggle="collapse"> <i class="icon-flask"></i>Chemicals
                            </a>
                            <ul id="chemicals" class="collapse list-unstyled show ">
                                <li class="active"><a href="chemical_item_registration.jsp">Registration</a></li>
                                <li><a href="chemical_receiving_note.jsp">Receiving Note</a></li>
                                <li><a href="chemical_stock_allocations.jsp">Stock
                                        Allocations</a></li>
                                <li><a href="chemical_stock_registration.jsp">Stock
                                        Registration</a></li>
                            </ul></li>
                        <li><a href="#clients" aria-expanded="false"
                               data-toggle="collapse"> <i class="icon-user"></i>Clients
                            </a>
                            <ul id="clients" class="collapse list-unstyled ">
                                <li><a href="client_agreement_details.jsp">Agreement
                                        Details</a></li>
                                <li><a href="client_general_cleaning_details.jsp">General
                                        Cleaning</a></li>
                                <li><a href="client_invoice_details.jsp">Invoice Details</a></li>
                                <li><a href="client_invoice.jsp">Invoice</a></li>
                                <li><a href="client_payment_details.jsp">Payment</a></li>
                                <li><a href="client_registration.jsp">Registration</a></li>
                            </ul></li>
                        <li><a href="#employee" aria-expanded="false"
                               data-toggle="collapse"> <i class="icon-user"></i>Employee
                            </a>
                            <ul id="employee" class="collapse list-unstyled ">
                                <li><a href="employee_attendance.jsp">Attendance </a></li>
                                <li><a href="employee_documents.jsp">Documents</a></li>
                                <li><a href="employee_epf_etf_registration.jsp">EPF ETF</a></li>
                                <li><a href="employee_job_transferring.jsp">Job
                                        Transferring</a></li>
                                <li><a href="employee_paysheet.jsp">Pay sheet</a></li>
                                <li><a href="employee_registration.jsp">Registration</a></li>
                                <li><a href="employee_salary_details.jsp">Salary Details</a></li>
                                <li><a href="employee_salary_schedule.jsp">Salary
                                        Schedule</a></li>
                                <li><a href="employee_type_registration.jsp">Salary Type</a></li>
                                <li><a href="employee_work_assignment.jsp">Work
                                        Assignment</a></li>
                                <li><a href="employee_working_schedule.jsp">Work
                                        Schedule</a></li>
                                <li><a href="leave_dates_allowances_schedule.jsp">Holiday
                                        Allowance</a></li>
                                <li><a href="pre_defined_allowances.jsp">Pre-Defined
                                        Allowance</a></li>
                                <li><a href="pre_defined_o_t_rate.jsp">Pre-Defined OT</a></li>
                                <li><a href="working_shift_salary_schedule.jsp">Shift Allowance</a></li>
                            </ul></li>
                        <li><a href="epf_etf_description.jsp"><i class="icon-padnote"></i>EPF
                                ETF</a></li>
                        <li><a href="#machinary" aria-expanded="false"
                               data-toggle="collapse"> <i class="fa fa-cubes"></i>Machinery
                            </a>
                            <ul id="machinary" class="collapse list-unstyled ">
                                <li><a href="machinary_allocations.jsp">Allocations </a></li>
                                <li><a href="machinary_modifications.jsp">Modification</a></li>
                                <li><a href="machinary_receiving_note.jsp">Receiving
                                        Note</a></li>
                                <li><a href="machinary_registration.jsp">Registration</a></li>
                                <li><a href="machinary_stock_registration.jsp">Stock
                                        Registration</a></li>
                            </ul></li>
                        <li><a href="#supplier" aria-expanded="false"
                               data-toggle="collapse"> <i class="icon-user"></i>Supplier
                            </a>
                            <ul id="supplier" class="collapse list-unstyled ">
                                <li><a href="supplier_payment_details.jsp">Payment </a></li>
                                <li><a href="supplier_registration.jsp">Registration</a></li>
                            </ul></li>
                        <li><a href="#user" aria-expanded="false"
                               data-toggle="collapse"> <i class="icon-user"></i>User
                            </a>
                            <ul id="user" class="collapse list-unstyled ">
                                <li><a href="user_privileges.jsp">Privileges </a></li>
                                <li><a href="user_registration.jsp">Registration</a></li>
                                <li><a href="user_type_registration.jsp">User Type</a></li>
                            </ul></li>

                        <li><a href="login.jsp"><i class="fa fa-sign-out"></i>Logout</a></li>
                    </ul>
                </nav>
                <div class="content-inner">
                    <!-- Page Header-->
                    <header class="page-header">
                        <div class="container-fluid">
                            <h2 class="no-margin-bottom">RST</h2>
                        </div>
                    </header>
                    <!-- Breadcrumb-->
                    <div class="breadcrumb-holder container-fluid">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html">Chemicals</a></li>
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
                                            <h3 class="h4">attedance</h3>
                                        </div>
                                        <div class="card-body">
                                            <form class="form-horizontal">
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">attendance id</label>
                                                    <div class="col-sm-9">
                                                        <input id="attendance_id" type="text"	placeholder="attendance id" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">month</label>
                                                    <div class="col-sm-9">
                                                        <input id="month" type="text"	placeholder="month" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">no of days</label>
                                                    <div class="col-sm-9">
                                                        <input id="no_of_days" type="text"	placeholder="no of days" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">no of ot</label>
                                                    <div class="col-sm-9">
                                                        <input id="no_of_ot" type="text"	placeholder="no of ot" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">bonus</label>
                                                    <div class="col-sm-9">
                                                        <input id="bonus" type="text"	placeholder="bonus" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">advance</label>
                                                    <div class="col-sm-9">
                                                        <input id="advance" type="text"	placeholder="advance" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-3 form-control-label">date time</label>
                                                    <div class="col-sm-9">
                                                        <input id="date_time" type="text"	placeholder="date time" class="form-control form-control-warning">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="col-sm-9 offset-sm-3">
                                                        <input onclick="save()" type="button" value="Save" class="btn btn-primary">
                                                        <input type="reset" value="Reset" class="btn btn-primary">
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-header d-flex align-items-center">
                                            <h3 class="h4">History</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="table-responsive">
                                                <table class="table table-hover" id="table">
                                                    <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>attendance id</th>
                                                            <th>month</th>
                                                            <th>no of days</th>
                                                            <th>no of ot</th>
                                                            <th>bonus</th>
                                                            <th>advance</th>
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


        <script src="ajax/ajax.js"></script>
        <script src="sweetalert/sw.js"></script>
        <script src="ajax/jquery.3.2.1.min.js"></script>
        <script src="ajax/AttedanceJS.js" type="text/javascript"></script>
    </body>
</html>