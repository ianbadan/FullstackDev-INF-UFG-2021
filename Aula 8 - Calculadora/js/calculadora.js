var bt0 = document.querySelector('.bt0');
var bt1 = document.querySelector('.bt1');
var bt2 = document.querySelector('.bt2');
var bt3 = document.querySelector('.bt3');
var bt4 = document.querySelector('.bt4');
var bt5 = document.querySelector('.bt5');
var bt6 = document.querySelector('.bt6');
var bt7 = document.querySelector('.bt7');
var bt8 = document.querySelector('.bt8');
var bt9 = document.querySelector('.bt9');

var btAdd = document.querySelector('.btAdd');
var btSub = document.querySelector('.btSub');
var btMul = document.querySelector('.btMul');
var btDiv = document.querySelector('.btDiv');

var btReset = document.querySelector('.btReset');
var btPonto = document.querySelector('.btPonto');
var btResut = document.querySelector('.btResut');

var num1 = 0;
var num2 = 0;
var op = null;
var resultado = null;
var concluido = false;
var decimal = false;
var display = document.querySelector('.display');
var negative = false

btAdd.addEventListener('click', function(){
    decimal = false;
    if(op == null){
        op = "+";
        addDisplay("+");
    } else{
        var temp = display.textContent.substring(0 , display.textContent.length-1);
        display.textContent = '';
        op = "+";
        addDisplay(temp + "+");
    }
});
btSub.addEventListener('click', function(){
    decimal = false;
    if(num1 == 0){
        addDisplay("-");
        negative = true;
    } else if(op == null){
        op = "-";
        addDisplay("-");
    } else{
        if(display.textContent.length == 1){
            var temp = display.textContent;
        } else{
            var temp = display.textContent.substring(0 , display.textContent.length-1);
        }

        display.textContent = '';
        op = "-";
        addDisplay(temp+"-");
    }
})
btMul.addEventListener('click',function () {
    decimal = false;
    if(op == null){
        op = "*";
        addDisplay("*");
    } else{
        if(display.textContent.length == 1){
            var temp = display.textContent;
        } else{
            var temp = display.textContent.substring(0 , display.textContent.length-1);
        }
        display.textContent = '';
        op = "*";
        addDisplay(temp+"*");
    }

})
btDiv.addEventListener('click', function() {
    decimal = false;
    if(op == null){
        op = "/";
        addDisplay("/");   
    } else{
        if(display.textContent.length == 1){
            var temp = display.textContent;
        } else{
            var temp = display.textContent.substring(0 , display.textContent.length-1);
        }
        display.textContent = '';
        op = "/";
        addDisplay(temp+"/"); 
    }
})
btPonto.addEventListener('click', function() {
    decimal = false;
    if(op == null){
        op = "%";
        addDisplay("%");
    } else{
        if(display.textContent.length == 1){
            var temp = display.textContent;
        } else{
            var temp = display.textContent.substring(0 , display.textContent.length-1);
        }
        
        display.textContent = '';
        op = "%";
        addDisplay(temp+"%");
    }
})


bt0.addEventListener('click', function(){
    addCalc(0);
    addDisplay(0);
});
bt1.addEventListener('click', function(){
    addCalc(1);
    addDisplay(1);
});
bt2.addEventListener('click', function(){
    addCalc(2);
    addDisplay(2);
});
bt3.addEventListener('click', function(){
    addCalc(3);
    addDisplay(3);
});
bt4.addEventListener('click', function(){
    addCalc(4);
    addDisplay(4);
});
bt5.addEventListener('click', function(){
    addCalc(5);
    addDisplay(5);
});
bt6.addEventListener('click', function(){
    addCalc(6);
    addDisplay(6);
});
bt7.addEventListener('click', function(){
    addCalc(7);
    addDisplay(7);
});
bt8.addEventListener('click', function(){
    addCalc(8);
    addDisplay(8);
});
bt9.addEventListener('click', function(){
    addCalc(9);
    addDisplay(9);
});

function addCalc(n){
    if(concluido){
        if(op == null)
        {
            reset();
            concluido = false;
        }
    }

    if(op == null){
        if(decimal){
            num1 += n/10;
        }else{
            num1 = num1*10 + n;
        }
        console.log(num1);
    }else{
        if(decimal){
            num2 += n/10;
        }else{
            num2 = num2*10 + n;
        }
    }


    if(op == null){
        btResut.disabled = true;
    }else{
        btResut.disabled = false;
    }
}

btResut.addEventListener('click', function(){
    if(negative == true){
        num1 = num1 * (-1);
        negative = false;
    }
    concluido = true;
    switch (op){
        case "+" :
            num1 = soma();
            break;
        case "-":
            num1 = subtracao();
            break;
        case "*":
            num1 =multiplicacao();
            break;
        case "/":
            num1 = divisao();
            break;
        case "%":
            num1 = resto();
            break;
    }
    op = null;
    num2 = 0;
})


function soma(){
    var temp = num1 + num2;
    setDisplay(temp);
    return temp;
}

function subtracao(){
    var temp;
    if(num1 < 0){
        temp = (num1 + (num2 * -1));
    }else {
        temp = num1 - num2;
    }
    setDisplay(temp);
    return temp;
}
    

function multiplicacao(params) {
    var temp = num1 * num2;
    setDisplay(temp );
    return temp;
}

function divisao(params) {
    if(num2 != 0){
        var temp = num1 / num2;
        setDisplay(temp );
        return temp;
    } else {
        setDisplay("Erro");
    }
}

function resto(params) {
    if(num2 != 0){
        var temp = num1 % num2;
        setDisplay(temp);
        return temp;
    } else {
        setDisplay("Erro");
    }
}

function addDisplay(n){
    //console.log(display.textContent.length);
    if(display.textContent.length < 12){
        display.textContent += n; 
    }
}

function setDisplay(str){
    display.textContent = str;
    if(display.textContent.length <= 12){
        display.textContent = display.textContent.trim();
    }else{
        display.textContent = display.textContent.substr(0, 11);
    }
}

btReset.addEventListener('click', reset);

function reset(){
    num1 = 0;
    num2 = 0;
    op = null;
    resultado = null;
    display.textContent = '';
    btResut.disabled = true;
    decimal = false;
}
