/**
 * Script pour l'auto-completion
 */

	$(function() {
		$("#nom").autocomplete({
			source : function(request, response) {
				$.ajax({
					url : "/culture/autocompletion",
					dataType : "json",
					method : "GET",
					data : {
						q : request.term
					},
					success : function(data) {
						//alert(data);
						console.log(data);
						response(data);
					}
				});
			},
			minLength : 1
		});
	});