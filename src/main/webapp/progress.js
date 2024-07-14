
/*
function startProgress()
{
    // ajax-запрос к серверу
    $.ajax({
        url : 'loadFilePath-servlet',  // сервлет
        success : function(responseText) {
            // обработка ответа
            $('#progressId').text(responseText + "%");
            var progress = parseInt(responseText);
            // при значении меньше 100 повторить запрос через 2 сек
            if (progress < 100) {
                setTimeout(startProgress, 2000);
            }
        }
    });
}
var myVar;
*/
function myFunction() {
    document.getElementById("loader").style.display = "run-in";


  //  myVar = setTimeout(showPage, 3000);
}

function showPage() {
    document.getElementById("loader").style.display = "block";
   document.getElementById("myDiv").style.display = "block";
}