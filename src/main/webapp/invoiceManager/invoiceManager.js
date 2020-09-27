let addInvoice = document.getElementById('addInvoice');
let invoiceContainer = document.getElementById('invoiceContainer');
let inputField = document.getElementById('inputField');




addInvoice.addEventListener('click', function(){
    var paragraph = document.createElement('p');
    paragraph.classList.add('paragraph-styling');
    paragraph.innerText = inputField.value;
    invoiceContainer.appendChild(paragraph);
    inputField.value = "";
    
    paragraph.addEventListener('click', function(){
        paragraph.style.textDecoration = "line-through";
    })


})

    
    


