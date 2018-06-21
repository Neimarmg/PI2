var elementoBody = document.querySelector("body");
elementoBody.onload = carregarMotores;

function carregarMotores(){
    setInterval(buscarMotores,3000);    
}
var i=0;
function buscarMotores(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){
            var main = document.querySelector("main");
            
            var listaMotores = JSON.parse(this.responseText);
            
            montarHTML(listaMotores);
            console.log(this.responseText);
        }
    }
    
    xhttp.open("GET","motores.json",true);
    xhttp.send();
}

function montarHTML(listaMotores){
     
    var str ="<fieldset>"+
                "<legend>Cadastro</legend> "+
            "<form>"
    str+= "</br>"
    str+= "</label>Nome:"
    str+= "</input>" +listaMotores[0].uso
    
    str+= "</fieldset>"+"</br>"+"</br>"
            "</form>"
    
    str += "<dl>";
    str+= "<dd>";
    str+= "<figure>";
    str+= "<img src='"+ listaMotores[0].imagem+
            "' alt='"+listaMotores[0].nome+"' />";
    str+= "</figure>";
    str+= "</dd>";
    str+= "<dt>";
    str+= "<a href='#'>"+listaMotores[0].nome+"</a>";
    str+= "</dt>";
    str+= "<dd>" +listaMotores[0].descricao+"</dd>";
    str+= "<dd>Uso: "+listaMotores[0].uso+"</dd>";
    str+= "</dl>";
    
    var elementoMain = document.querySelector("main");
    elementoMain.innerHTML = str;
}
        


