<%--
  Created by ECLIPSE.
  User: dereklee
  Last Editor: dereklee
  Date: 2017-07-22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ include file="/WEB-INF/views/includes/nav.jsp"%>

<div class="main">

<div class="jumbotron text-center">
  <h1>Hello, Everyone!</h1>
  <p>This is small shopping mall made by donghyun and DerekLee</p>
  <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/board/list.do?s=product" role="button">Look around</a></p>
</div>
<div class="container">
    <div class="row">
		<div class="col-md-12">
                <div id="Carousel" class="carousel slide">
                 
                <ol class="carousel-indicators">
                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#Carousel" data-slide-to="1"></li>
                    <li data-target="#Carousel" data-slide-to="2"></li>
                </ol>
                 
                <!-- Carousel items -->
                <div class="carousel-inner">
                    
                <div class="item active">
                	<div class="row">
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/image2.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/image2.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/image2.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	  <div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/image2.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                <div class="item">
                	<div class="row">
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/default.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/default.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/default.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/default.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                <div class="item">
                	<div class="row">
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/download.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/download.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/download.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                		<div class="col-md-3"><a href="#" class="thumbnail"><img src="../resource/upload/download.jpg" alt="Image" style="width:250;max-width:100%;"></a></div>
                	</div><!--.row-->
                </div><!--.item-->
                 
                </div><!--.carousel-inner-->
                  <a data-slide="prev" href="#Carousel" class="left carousel-control">‹</a>
                  <a data-slide="next" href="#Carousel" class="right carousel-control">›</a>
                </div><!--.Carousel-->
                 
		</div>
	</div>
</div><!--.container-->
</div>

<!-- javascript -->
<script type="text/javascript">
$(document).ready(function() {
    $('#Carousel').carousel({
        interval: 5000
    })
});
</script>


</body>
</html>
