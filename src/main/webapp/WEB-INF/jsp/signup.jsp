<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign
										up</p>

									<form:form method="post" modelAttribute="clientForm"
										action="/signup">
											<div class="form-group ">
												<label>Name</label>
												<form:input class="form-control" path="name" type="text" id="name" />
												<form:errors path="name" class="text-danger"/>
											</div>
											<div class="form-group ">
												<label>Email</label>
												<form:input class="form-control" path="email" type="email" id="email" />
												<form:errors path="email" class="text-danger"/>
											</div>
											<div class="form-group ">
												<label>Password</label>
												<form:input class="form-control" path="password" type="password" id="password" />
												<form:errors path="password" class="text-danger"/>
											</div>
										<button class="btn btn-success mt-2" type="submit" >SignUp</button>
										<p> ${successMessage}</p>
									</form:form>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>