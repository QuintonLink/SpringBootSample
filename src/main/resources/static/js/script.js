var current = "purple";
var colors = ["none","none","none","none","none","none","none","none","none"];


function turn(number) {
    $("#s" + number).animate({
        backgroundColor : current,
    },500);
    $("#s" + number).prop("disabled","true");
    colors[number - 1] = current;
    if (current === "purple") {
        current = "black";
    } else {
        current = "purple";
    }

    var result = check();

    if(result != "none"){
        $("#result").animate({
            backgroundColor : result,
        }, 200)
    }
    $("#result").text("Winner is");
}






function check(){
    if(colors[0] == colors[1] && colors[1] == colors[2] && colors[0] != "none"){
        return colors[0];
    }
    if(colors[3] == colors[4] && colors[4] == colors[5] && colors[3] != "none"){
        return colors[3];
    }
    if(colors[6] == colors[7] && colors[7] == colors[8] && colors[6] != "none"){
        return colors[6];
    }
    if(colors[0] == colors[3] && colors[3] == colors[6] && colors[0] != "none"){
        return colors[0];
    }
    if(colors[1] == colors[4] && colors[4] == colors[7] && colors[1] != "none"){
        return colors[1];
    }
    if(colors[2] == colors[5] && colors[5] == colors[8] && colors[2] != "none"){
        return colors[2];
    }
    if(colors[0] == colors[4] && colors[4] == colors[8] && colors[0] != "none"){
        return colors[0];
    }
    if(colors[2] == colors[4] && colors[4] == colors[6] && colors[2] != "none"){
        return colors[2];
    }

    for(var i = 0; i < 8; i++){
        if(colors[i] == "none"){
            return "";
        }
        else{
            return "draw";
        }

    }

}