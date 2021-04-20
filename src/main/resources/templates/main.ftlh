<!DOCTYPE html>
<html>
  <head>
	  <meta charset="UTF-8">
	  <meta name="viewport"
			content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	  <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Индекс счастья</title>

	  <link rel="shortcut icon" href="./images/favicon.png">
	  <link rel="stylesheet" type="text/css" href="./styles/main/style.css"/>
	  <script type="text/javascript" src="https://apis.google.com/js/platform.js"></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	  <script type="text/javascript" src="./scripts/main.js"></script>
  </head>
  <body>
  <div id="scene_box">
	  <div id="zatemnenie"></div>
	  <div id="main_box">
		  <div class="box cover">
			  <div class="box control_panel_buttons">
				  <button class="button" type="button" onclick="show_ld_window()">Выбрать пользователей</button>
			  </div>
			  <div class="box users" id="found_users_view">

			  </div>
		  </div>
		  <div class="box cover">
			  <div class="data" id="user_info_view">

			  </div>
		  </div>
	  </div>
  </div>

  <div id="window_users" align="center" >
	  <div id="wrapper">
		  <div class="text_p">Введите данные</div>
	  </div>
	  <div id="wrapper">
		  <form>
			  <input class="input_elem" name="name" id="name" placeholder="Имя">
			  <input class="input_elem" name="surname" id="surname" placeholder="Фамилия">
			  <div id="wrapper_buttons">
				  <form>
					  <button class="buttons" type="button" onclick="find_users()">Применить</button>
				  </form>
				  <form>
					  <button class="buttons" type="button" onclick="close_ld_window()">Отмена</button>
				  </form>
			  </div>
		  </form>
	  </div>
  </div>
  </body>
</html>