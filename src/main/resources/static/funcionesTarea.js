function eliminarTarea(id){
	swal({
  title: "estas seguro de eliminar?",
  text: "Once deleted, you will not be able to recover this imaginary file!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((ok) => {
  if (ok) {
	  $.ajax({
		  url:"/eliminarTarea/"+id,
		  success: function(res) {
			  console.log(res);
		  }	  
		  
	  });
    swal("Poof! Your imaginary file has been deleted!", {
      icon: "success",
    }).then ((ok)=>{
		if(ok){
			location.href="/listarTareas";
		}
	});
  } else {
    swal("Your imaginary file is safe!");
  }
});
	
} 