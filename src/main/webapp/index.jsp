<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Comidas Ocasional</title>
  <link rel="icon" href="/src/pages/resources/icon.png">
  <style>
    * {
    font-family: sans-serif;
}

body {
    background-color: 	#524556;
}


.ComOcaIMG {
    position: absolute;
    top: 25%;
    left: 50%;
    height: 256px;
    width: 256px;
    transform: translate(-50%, -50%);
}

.grid {
    display: grid;
    grid-template-columns: auto auto auto;
    grid-gap: 5px;
    padding: 5px;
    margin-top: 27%;
    margin-left: 10%;
}

.Button{
    cursor: pointer;
    background-color: #EC7B59;
    border-radius: 10px;
    position: relative;
    width: 250px;
    height: 50px;
    text-align: center;
    box-shadow: inset 2px 2px 2px rgba(0, 0, 0, 0.2);
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
    border: 0;
    color: #ffffff;
}

.Button:hover{
    background-color:#CE4646;
    border-radius: 10px;
    position: relative;
    align-items: center;
    width: 250px;
    height: 50px;
    box-shadow: inset 2px 2px 2px rgba(0, 0, 0, 0.2);
    text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.5);
}

fieldset {
    border: 2px solid #CE4646;
    box-shadow: inset 4px 4px 4px rgba(0, 0, 0, 0.2);
    padding: 0;
    margin-left: 33%;
    background-color: #E4DDCB;
    border-radius: 25px;
}

fieldset.group .grid {
    float: top;
    margin-top: 2.5em;
    margin-bottom: 2.5em;
}
  </style>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
  
    <div>
      <a href="https://bit.ly/LinkMuitoLegal"><img src="https://i.imgur.com/EQqcUma.png"class="ComOcaIMG"></a>
    </div>

    <div class="grid">

      <fieldset class="group">

        <div class="grid">
          <a href="/src/Pages/loginCliente.html" class="Button" name="Login">
            <input type="button" value="Login de Usuário →" class="Button">
          </a>
        </div>
        
        <div class="grid">
          <a href="/src/pages/cadastroCliente.html" class="Button" name="cadasusua">
            <input type="button" value="Cadastro de Usuário →" class="Button">
          </a>
        </div>

      </fieldset>
      
      <fieldset class="group">

        <div class="grid">
          <a href="/src/Pages/loginEstabelecimento.html" class="Button">
            <input type="button" value="Login de Estabelecimento →" class="Button">
          </a>
        </div>
  
        <div class="grid">
          <a href="/src/pages/cadastroEstabelecimento.html" class="Button" name="cadasesta">
            <input type="button" value="Cadastro de Estabelecimento →" class="Button">
          </a>
        </div>

      </fieldset>

      </div>

</body>
</html>