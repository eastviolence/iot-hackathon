$( document ).ready(function() {
    $.get( "../things", function( data ) {
      console.log("DATA!", data);
    });
});