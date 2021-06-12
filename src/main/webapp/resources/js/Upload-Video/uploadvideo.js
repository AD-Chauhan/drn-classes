$(document).ready(function(){
	$('#videoUploadForm').validate(
			{
				errorElement : 'div',
				errorClass : 'help-block',
				onfocusout : false,
				onblur : false,
				rules : {
					videoName : {
						required : true

					},
					videoTitle : {
						required : true

					},
					courseCategory : {
						required : true

					},
					description : {
						required : true

					},
					batch  : {
						required : true
					},
					chapterFileName  : {
						required : true
					},
					
					

				},
				highlight : function(e) {
					$(e).closest('.form-group').removeClass('has-info').addClass(
							'has-error');
				},
				success : function(e) {
					$(e).closest('.form-group').removeClass('has-error');
					$(e).remove();
				},
				errorPlacement : function(error, element) {

					if (element.is('input[type=checkbox]')
							|| element.is('input[type=radio]')) {
						var controls = element.closest('div[class*="col-"]');
						if (controls.find(':checkbox,:radio').length > 1)
							controls.append(error);
						else
							error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
					} else if (element.is('.select2')) {
						error.insertAfter(element
								.siblings('[class*="select2-container"]:eq(0)'));
					} else if (element.is('.chosen-select')) {
						error.insertAfter(element
								.siblings('[class*="chosen-container"]:eq(0)'));
					} else
						error.insertAfter(element.parent());
					
				},
				submitHandler : function(form) {
					form.submit();
				}
			});

});