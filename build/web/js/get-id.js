function getId(object){
    var id = $(object).parent().parent().children("#id").text();
    alert(id);
}