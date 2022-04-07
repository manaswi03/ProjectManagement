<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          <%@ page isELIgnored = "false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
<!-- Font Awesome -->
  <link rel="stylesheet" href='<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>'>
  <!-- Ionicons -->
  <link rel="stylesheet" href='<c:url value="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"/>'>
  <!-- DataTables -->
  <link rel="stylesheet" href='<c:url value="/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"/>'>
  <link rel="stylesheet" href='<c:url value="/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css"/>'>
  <!-- Theme style -->
  <link rel="stylesheet" href='<c:url value="/resources/dist/css/adminlte.min.css"/>'>
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<!-- SweetAlert2 -->

<link rel="stylesheet" href='<c:url value="/resources/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css"/>'>
<!-- SweetAlert2 -->
<%@ include file="head.jsp" %>  

</head>
<body>
<%@ include file="menu.jsp" %>  


<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Students Details</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Student Details</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>
 

<section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-12">
 			<div class="card">
              <div class="card-header">
                <h3 class="card-title">All Student </h3>
              </div>
              
              <!-- /.card-header -->
              <div class="card-body">
                <table id="example1" class="table table-bordered table-striped">
                  <thead>
                  <tr>
                    <th>Product Id</th>
	 				  <th>Product Title</th>
	 				  <th>product Price</th>
	 				  <th>Discount Price</th>
	    			  <th>Product Brand</th>
	    			  <th>Category Name</th>
	 				  <th>Product Name</th>
					  <th>product Description</th>
	 	 			  <th>Quantity </th>
	 				  <th>Action</th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${productList}" var="product">
                  <tr>
               		  <td>${product.productId}</td>
	 				  <td>${product.productTitle}</td>
	 				  <td>${product.productPrice}</td>
	 				  <td>${product.productDiscountPrice}</td>
	    			  <td>${product.productBrand}</td>
	    			  <td>${product.categoryName}</td>
 				  	  <td>${product.productName}</td> 
					  <td>${product.productDescription}</td>
	 	 			  <td>${product.quantity}</td>
	 				  <td>
	 				  
	 				  <a href="editProduct/${product.productId}" class="btn btn-primary"><ion-icon name="create-outline"></ion-icon></a>  &nbsp;&nbsp;&nbsp;
	 				  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modal-danger" data-id="${product.productId}"><ion-icon name="trash-outline"></ion-icon></button>
	 				  
	 				  </td>
					</tr>
                  </c:forEach>
                 </tbody>
                 
                </table>
              </div>
       
            </div>
      
          </div>
    
        </div>
  
      </div>
 
 </section>


	  <div class="modal fade" id="modal-danger">
        <div class="modal-dialog">
          <div class="modal-content bg-danger">
            <div class="modal-header">
              <h4 class="modal-title">Are You Sure Do You Want To Delete ?</h4>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
              </div>
      
            <div class="modal-footer justify-content-between">
              <button type="button" class="btn btn-outline-light" data-dismiss="modal">Close</button>
               <a href="#" id="deletebtn" class="btn btn-outline-light">Delete</a>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div> 



</div>

<%@ include file="footer.jsp" %> 

<script src='<c:url value="/resources/plugins/jquery/jquery.min.js"/>'></script>
<!-- Bootstrap 4 -->
<script src='<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>'></script>
<!-- DataTables -->
<script src='<c:url value="/resources/plugins/datatables/jquery.dataTables.min.js"/>'></script>
<script src='<c:url value="/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"/>'></script>
<script src='<c:url value="/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"/>'></script>
<script src='<c:url value="/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"/>'></script>
<!-- AdminLTE App -->
<script src='<c:url value="/resources/dist/js/adminlte.min.js"/>'></script>
<!-- AdminLTE for demo purposes -->
<script src='<c:url value="/resources/dist/js/demo.js"/>'></script>
<!-- page script -->
<script src='<c:url value="/resources/plugins/sweetalert2/sweetalert2.min.js"/>'></script>
<script type="text/javascript">

$(document).ready(function($) {
	
	$('#example1').DataTable({
	      "paging": true,
	      "lengthChange": true,
	      "searching": true,
	      "ordering": true,
	      "info": true,
	      "autoWidth": true,
	      "responsive": true
	    });
	
	
	$('#modal-danger').on('show.bs.modal', function (event) {
		
		  var button = $(event.relatedTarget) 
		  var proId = button.data('id'); 
		 $('#deletebtn').attr('href','deleteProduct/'+proId);
	})
	
});


</script>

</body>
</html>