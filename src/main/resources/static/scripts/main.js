function show_ld_window(){
    document.getElementById("zatemnenie").style.display = 'block';
    document.getElementById("window_users").style.display = 'flex';
}

function close_ld_window(){
    document.getElementById("zatemnenie").style.display = 'none';
    document.getElementById("window_users").style.display = 'none';
}

function find_users(){
    let name = document.getElementById('name');
    let surname = document.getElementById('surname');

    document.getElementById("zatemnenie").style.display = 'none';

    $("#main_box").addClass("disabled");
    close_ld_window();

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/main/getusers?name="+name.value+"&surname="+surname.value,
        cache: false,
        timeout: 180000,
        success: function (data) {
            setFoundUsers(data);
            $("#main_box").removeClass("disabled");
        },
        error: function (data) {
            alert("Error while execution");
            $("#main_box").removeClass("disabled");
        }
    });
}

function setFoundUsers(data){
    let table = data;
    let table_html = '<div class="found_users">';
    if (table != null) {
        for (let i = 0; i < table.length; i++) {
            let id = table[i].substring(0, table[i].indexOf(":"));
            table_html+="<div class=\"found_user\" onclick=\'getUserInfo("+id+")\'>";
            table_html+=table[i];
            table_html+="</div>";
        }
        table_html+="</div>";
    }
    else table_html+="Ничего не найдено" + "</div>";
    $('#found_users_view').html(table_html);

    table_html = '<div class="user_info"></div>';
    $('#user_info_view').html(table_html);
}

function getUserInfo(id){
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/main/getuserinfo?id="+Number(id),
        cache: false,
        timeout: 180000,
        success: function (data) {
            setUserInfo(data);
            $("#main_box").removeClass("disabled");
        },
        error: function (data) {
            alert("Error while execution");
            $("#main_box").removeClass("disabled");
        }
    });
}

function setUserInfo(data){
    let table_html = '<div class="user_info">';

    table_html+="<table><tr><td>";
    table_html+="<div class=\"user_info_title\">";
    table_html+="#" + data.id+ ". " + data.name + " " +data.surname;
    table_html+="</div>";

    table_html+="<div class=\"user_info_diagram_title\">";
    table_html+="Данные";
    table_html+="</div>";

    let info = data.data;
    for (let i = 0; i < info.length; i++) {
        table_html+="<div class=\"user_info_data\">";
        table_html+=info[i];
        table_html+="</div>";
    }

    table_html+="</td><td style='padding-left: 50px;'><div class=\"user_info_diagram_title\">";
    table_html+="Диаграмма счастья";
    table_html+="</div>";

    table_html+="<canvas id=\"diagram\" width=\"300\" height=\"300\"></canvas>";
    table_html+="</div>";

    table_html+="</td></tr></table>";

    $('#user_info_view').html(table_html);

    draw_diagram(data.indexes);
}

function draw_diagram(indexes){
    let canvas = document.getElementById('diagram');
    let context = canvas.getContext('2d');

    context.strokeStyle = "#000";
    context.beginPath();
    context.arc(150,150,75,0,Math.PI*2,true);
    context.closePath();
    context.stroke();

    context.beginPath();
    context.moveTo(150, 25);
    context.lineTo(150, 275);
    context.stroke();

    context.beginPath();
    context.moveTo(25, 150);
    context.lineTo(275, 150);
    context.stroke();

    context.beginPath();
    context.moveTo(50, 250);
    context.lineTo(250, 50);
    context.stroke();

    context.font = "15px Arial";
    context.fillText("Деньги", 125, 20);

    context.font = "15px Arial";
    context.fillText("Здоровье", 120, 290);

    context.font = "15px Arial";
    context.fillText("Любовь", 0, 140);

    context.font = "15px Arial";
    context.fillText("Друзья", 250, 140);

    context.font = "15px Arial";
    context.fillText("Работа", 25, 270);

    context.font = "15px Arial";
    context.fillText("Хобби", 235, 40);

    let points = [];
    points.push([150, 150-75*(indexes[0]/10)]);
    points.push([(150+75*(indexes[5]/10)*Math.sqrt(2)/2)|0, (150-75*(indexes[5]/10)*Math.sqrt(2)/2)|0]);
    points.push([150+75*(indexes[3]/10), 150]);
    points.push([150, 150+75*(indexes[1]/10)]);
    points.push([(150-75*(indexes[4]/10)*Math.sqrt(2)/2)|0, (150+75*(indexes[4]/10)*Math.sqrt(2)/2)|0]);
    points.push([150-75*(indexes[2]/10), 150]);

    context.strokeStyle = "#263cff";
    let point1 = points[0];
    for (let i = 1; i < points.length; i++) {
        context.beginPath();
        context.moveTo(point1[0], point1[1]);
        context.lineTo(points[i][0], points[i][1]);
        context.stroke();
        point1=points[i];
    }
    context.beginPath();
    context.moveTo(point1[0], point1[1]);
    context.lineTo(points[0][0], points[0][1]);
    context.stroke();
}