<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>A.T.D. Terminal</title>

<!-- Bootstrap -->
<link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="registration.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
</head>
<body>
	<div class="container" style="margin-top: 50px;">
			

			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4"
					style="background-color: rgba(238,238,238,0.8); border: 1px solid #0099CC; border-opacity: 0.2; border-radius: 0px; padding: 15px 15px 15px 15px;">
					<h1 style="text-align: center; color: #0099CC; margin-bottom: 20px; font-size:32px;">AutoTotaalDienst</h1>
					<!-- Inloggen -->
					<h4 class="modal-title">Aanmelden:</h4>

					<form action="LoginServlet.do" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input type="email"
								name="email" class="form-control" id="exampleInputEmail1"
								placeholder="Vul email in">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Wachtwoord</label> <input
								type="password" name='password' class="form-control"
								id="exampleInputPassword1" placeholder="Vul wachtwoord in">
						</div>
						<div>
							<label> <input type="checkbox"> <span
								style="font-weight: 200;">Blijf aangemeld</span>
							</label>
						</div>
						<div class="btn-toolbar" role="toolbar" aria-label="label">
							<button type="submit" class="btn"
								style="background-color: #0099CC; color: #FFFFFF;">Aanmelden</button>
							<button type="button" class="btn" data-toggle="modal"
								data-target="#myModal"
								style="background-color: #0099CC; color: #FFFFFF;">Registreren</button>
						</div>


					</form>
					<%
				Object succes = request.getAttribute("succes");
				if (succes != null) {
					out.println(succes);
				}			 
			%>
			<%
				Object msg = request.getAttribute("succesReg");
				if(msg != null){
					out.println(msg);
				}
			%>
					<span>&nbsp;</span>

				</div>
		</div>

		<div class="col-md-4"></div>
	</div>

	<!-- Model Registration -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content"
				style="border: 1px solid #0099CC; border-radius: 0px; background-color: rgba(238,238,238,0.9);">


				<div class="modal-body">
					<h4 class="modal-title">Registratie</h4>
					<form action="RegisterServlet.do" method="post" onsubmit="return validateElements();" action="#">
						<div class="row">
							<div class="col-md-6">
							<div class="form-group">
								<label for="emailreg">Emailadres</label> <input type="email"
									name="emailreg" onblur='validateElement("emailreg");' 
									class="form-control" id="emailreg" placeholder="Vul email in">
                  <span id="emailRegErr"></span>
							</div>
							<div class="form-group">
								<label for="emailrep">Herhaal emailadres</label> <input
									type="email" name="emailrep"
									class="form-control" onblur='validateElement("emailrep");' 
									id="emailrep" placeholder="Herhaal email">
                  <span id="emailRepErr"></span>
							</div>
							<div class="form-group">
								<label for="passwordreg">Wachtwoord</label> <input
									type="password" name="passwordreg" onblur='compareInput("passwordreg", "passwordrep");' 
									class="form-control" id="passwordreg"
									placeholder="Vul wachtwoord in">
                  <span id="passwordRegErr"></span>
							</div>
							<div class="form-group">
								<label for="passwordrep">Herhaal wachtwoord</label> <input
									type="password" name="passwordrep" onblur='compareInput("passwordrep", "passwordreg");'
									class="form-control" id="passwordrep"
									placeholder="Herhaal wachtwoord">
                  <span id="passwordRepErr"></span>
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-group">
								<label for="surname">Voornaam</label> <input type="text"
									name="surname" class="form-control" id="surname"
									placeholder="Vul voornaam in">
                  <span id="surnameErr"></span>
							</div>
							<div class="form-group">
								<label for="lastname">Achternaam</label> <input type="text"
									name="lastname" class="form-control" id="lastname"
									placeholder="Vul achternaam in">
                  <span id="lastmnameErr"></span>
							</div>
							<div class="form-group">
								<label for="address">Adres</label> <input type="text"
									name="address" class="form-control" id="address"
									placeholder="Vul adres in">
                  <span id="addressErr"></span>
							</div>
							<div class="form-group">
								<label for="country">Land</label> <input type="text"
									name="country" class="form-control" id="country"
									placeholder="Vul land in">
                  <span id="countryErr"></span>
							</div>
						</div>
						<div class="row" style="margin-left:16px;">
						<div class="btn-toolbar" role="toolbar" aria-label="label">
						<button type="button" class="btn" data-dismiss="modal" style="border-color: #0099CC;background-color: #FFF;  color: #626262;">Annuleren</button>
						<button type="button" class="btn" value="submit"
								id="buttonReg" style="background-color: #0099CC; color: #FFF;">Registreren</button>
						</div>
					</div>

					</div>
					</form>



				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
	<script src="registration.js"></script>
</body>
</html>