function getId(object){
    var id = $(object).parent().parent().children("#id").text();
    return id;
}