function dryCleanValidate(){
		
		var qtyLen  = document.forms["DryCleanForm"]["quantity"].length;
		var cDay = document.forms["DryCleanForm"]["currentDate"].value;
		var pDay = document.forms["DryCleanForm"]["pickDate"].value;

		var q  =  new Array();
		
		var i = 0;
	
		for( i = 0; i < qtyLen; ++i ){
			q = document.getElementsByName("quantity")[i].value;
			if( q < 0 ){
				alert("You cannot enter negative values");
				return false;
			}
			else{
				isNumeric( q )
			}
		}//end for
		
		if( pDay == "" || pDay == null ){
			alert("Please enter a pick date ");
			return false;
		}
		
	
	}
	

	function isEmpty( elemValue , field ){
		
		if( elemValue == "" || elemValue == null ){
			alert( "You cannot have  the " + field + " empty");
			return true;
		}else{
			return false;
		}
	}
	
	function isNumeric( elemValue ){
		var exp = /^[0-9]+$/;
		
		if( !isEmpty( elemValue , "Quantity")){
			
			if( elemValue.match(exp) ){
				return true;
			}
			else{
				alert("Enter only Numbers  to the fieild");
				return false;
			}
		}
	}
	