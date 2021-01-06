$(document ).ready(function() {
    console.log( "ready!" );
    getList();
    var modal = document.getElementById("myModal");
              // Get the button that opens the modal
              var btn = document.getElementById("myBtn");
              // Get the <span> element that closes the modal
              var span = document.getElementsByClassName("close")[0];
              // When the user clicks the button, open the modal
              btn.onclick = function() {
                modal.style.display = "block";
              }
              // When the user clicks on <span> (x), close the modal
              span.onclick = function() {
                  { id: $('input#id').val("")}
                  { name: $('input#name').val("")}
                  { brand: $('input#brand').val("")}
                  { madein: $('input#madein').val("")}
                  { price: $('input#price').val("")}
                    modal.style.display = "none";
              }
              // When the user clicks anywhere outside of the modal, close it
              window.onclick = function(event) {
                if (event.target == modal) {
                  modal.style.display = "none";
                }
              }
             var btnSave = document.getElementById("save");
              btnSave.onclick = function() {
                    console.log("save-------------------------")
                 var data = {
                     id: $('input#id').val(),
                     name: $('input#name').val(),
                     brand: $('input#brand').val(),
                     madein: $('input#madein').val(),
                      price: $('input#price').val(),
                 };
                 $.post('/save', data, function(data) {
                    console.log(data);
                    location.reload(data);
                  getList();
                 });
              }
});
function addRow(product) {
let markup =        '<tr>'+
                         '<td>'+product.id+'</td>'+
                         '<td>'+product.name+'</td>'+
                         '<td>'+product.brand+'</td>'+
                         '<td>'+product.madein+'</td>'+
                         '<td>'+product.price+'</td>'+
                         '<td>'+
                            '<button onclick="deleteRow('+product.id+')" id="deleteBtn" >удалить</button>'+
                            '<button onclick="updateRow('+product.id+')" id="updateBtn">редактировать</button>'+
                         '</td>'+
                     '</tr>';
$("#table1 tbody").append(markup);
}

function getList() {
   $.ajax({url: "/list", success: function(result){
       console.log(result);
       for(var i=0; i<result.length; i++) {
           addRow(result[i]);
       }
     }});
}
function deleteRow(id) {
$.ajax({url: "/delete/"+id, type: 'DELETE', success: function(result){
    console.log(result);
location.reload(id);

  }});
}

function updateRow(id) {
    $( document ).ready(function(){
	    $( "#myModal" ).show();
	});
    $.ajax({url: "/get/"+id, type: 'GET', success: function(result) {
        console.log("result", result);
        { id: $('input#id').val(result.id)}
        { name: $('input#name').val(result.name)}
        { brand: $('input#brand').val(result.brand)}
        { madein: $('input#madein').val(result.madein)}
        { price: $('input#price').val(result.price)}
    }});
 }




