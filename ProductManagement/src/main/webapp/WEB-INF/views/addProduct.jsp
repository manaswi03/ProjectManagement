<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ page isELIgnored = "false" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
            <h1>${Action} Product  Data</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">${Action} Product</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
         
          <div class="col-md-12">
            <!-- general form elements disabled -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">${Action} Product</h3>
              </div>
             
             
              <!-- /.card-header -->
              <div class="card-body">
                <form role="form" action="/ProductManagement/productHandler" method="post" id="quickForm">
                <input type="hidden" name="productId" id="productId" value="${product.productId}"> 
                
                <input type="hidden" value="${product.productTypeId}" id="productTypeId"> 
                
                
              		<div class="form-group">
                        <label>Prodcut Title</label>
                        <input type="text" class="form-control" value="${product.productTitle}" placeholder="Enter Product Title" name="productTitle">
                    </div>
                    
                    <div class="row">
                    	<div class="col-sm-6">
		                    <div class="form-group">
		                        <label>Prodcut Price</label>
		                        <input type="text" class="form-control" value="${product.productPrice }" placeholder="Enter Product Price" name="productPrice">
		                    </div>
		                    </div>
		                    <div class="col-sm-6">
		                    <div class="form-group">
		                        <label>Prodcut Discount Price</label>
		                        <input type="text" class="form-control" value="${product.productDiscountPrice}" placeholder="Enter Product Discount Price" name="productDiscountPrice">
		                    </div>
                    	</div>
                    </div>
                    
                    
                    <div class="form-group">
                        <label>Prodcut Brand</label>
                        <input type="text" class="form-control" placeholder="Enter Product Brand" value="${product.productBrand}" name="productBrand">
                    </div>
                    
                    
                    <div class="form-group">
                        <label>Product Description</label>
                        <textarea class="form-control" name="productDescription" rows="3" placeholder="Enter Product Description">${product.productDescription}</textarea>
                     </div>
                    
                    
                    <div class="form-group">
                        <label>Product Quantity</label>
                        <input type="number" class="form-control" value="${product.quantity}" placeholder="Enter Product Brand" name="quantity">
                    </div>
                      
                    
                    <div class="row">
                    <div class="col-sm-6">
                      <!-- select -->
                      <div class="form-group">
                        <label>Select Category</label>
                        <select class="form-control" name="categoryId" id="categoryId">
                        <option value="0">Choose Category</option>
                        <c:forEach items="${allCategory}" var="category">
                        	<option value="${category.categoryId}" <c:if test="${product.categoryId == category.categoryId }">selected="selected"</c:if> >${category.categoryName}</option>
                        </c:forEach>
  						 
                        </select>
                      </div>
                    </div>
                    
                    
                    <div class="col-sm-6">
                      <!-- select -->
                      <div class="form-group">
                        <label>Select Type</label>
                        <select class="form-control" name="productTypeId" id="prodcutList">
                        <option>Select Product Type</option>
                        
                        </select>
                      </div>
                    </div>
                    </div>
                    
                     
                     <div class="row">
               			<div class="col-sm-4">
               			</div>
               			<div class="col-sm-4">
                            <button  type="submit" class="btn btn-block btn-outline-primary"  id="btnCheck">${Action}</button>
       					</div>
       				</div>
                    
       	        </form>
        </div>
        </div>
        </div>
        </div>
        </div>
        </section>
        </div>

<%@ include file="footer.jsp" %> 
<script src='<c:url value="/resources/plugins/jquery-validation/jquery.validate.min.js"/>'></script>
<script src='<c:url value="/resources/plugins/jquery-validation/additional-methods.min.js"/>'></script>
<script type="text/javascript">

$(document).ready(function($) {
	
	var categoryId = $("#categoryId").val();
	var productTypeId = $("#productTypeId").val();
	//alert(productTypeId);
	$.ajax({
		
		type : "GET",
		url : "productType/"+categoryId+"/"+productTypeId,
		success : function(response){
			$("#prodcutList").html(response);
		}
	});
	
	//var productId = $("#productId").val(); alert(productId.length);
	$("#categoryId").on("change",function(){
			
			var categoryId = $(this).val();
			/* var url = "/editProduct/productType/"+categoryId; 
			if(productId.length == 0) {
				url =  "productType/"+categoryId;
			}
			alert(url); */
			$.ajax({
				type : "GET",			
				url : "productType/"+categoryId,
				success : function(response){
					var data= "<option value='0'>Choose Product Type</option>"
					for(var i=0;i<response.length;i++){
						data += "<option value='"+response[i].productTypeId+"'>"+response[i].productName+"</option>";
					}
					
					$("#prodcutList").html(data);
				}
			});
		
	});
	
	
	$('#quickForm').validate({
		 
	    rules: {
	      productTitle: {
		        required: true
		   },
		   productPrice: {
		        required: true
		   },
		   productDiscountPrice : {
		        required: true
		   },
		   productBrand : {
		        required: true
		   },
		   categoryId : {
		        required: true
		   },
		   productTypeId :  {
		        required: true
		   },
		   productDescription :  {
		        required: true
		   },
		   quantity :  {
		        required: true
		   },
	      
	    },
	    messages: {
	      
	      productTitle: "Please provide a product Title",
	      productPrice: "Please provide a product Price ",
	      productDiscountPrice: "Please provide a Discount Price",
	      productBrand : "Please Provide a product Brand",
	      categoryId:"Please select a Category ",
	      productTypeId: "Please select a Prodcut Type",
	      productDescription : "Please Provide product Description",
	      quantity : "Please Provide a product quantity"
	    },
	    errorElement: 'span',
	    errorPlacement: function (error, element) {
	      error.addClass('invalid-feedback');
	      element.closest('.form-group').append(error);
	    },
	    highlight: function (element, errorClass, validClass) {
	      $(element).addClass('is-invalid');
	    },
	    unhighlight: function (element, errorClass, validClass) {
	      $(element).removeClass('is-invalid');
	    }
 });
  
}); 


</script>
</body>
</html>