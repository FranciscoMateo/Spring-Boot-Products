$(function() {
	
    $('.supplier-select').on('change', function(){
    	if($(this).val()){
    		$('.supplier-select-panel .btn-success').removeClass('disabled');
    	} else {
    		$('.supplier-select-panel .btn-success').addClass('disabled');
    	}
    });
    
    $('.supplier-select-panel .btn-success').on('click', function(e){
    	e.preventDefault();
    	
    	var supplier_selected = $('.supplier-select').val();
    	var if_added_supplier = false;
    	
    	$('.suppliers-panel li>input').each(function(){
    		console.log(supplier_selected + ' ...' + $(this).val() );
    		if(supplier_selected == $(this).val()){
    			if_added_supplier = true;
    		}
    	});
    	
    	if(!if_added_supplier){
    		$supplier_item = $('.supplier-template').clone();
    		$supplier_item.find('span').text($('.supplier-select option:selected').text());
    		$supplier_item.find('input').val($('.supplier-select').val());
    		
    		$('.suppliers-panel ul').append($supplier_item);
    		
    		$supplier_item.removeClass('d-none');
    	}
    	$('.supplier-select').val('');
		$('.supplier-select').trigger('change');
    });
    
    $('.suppliers-panel .btn-danger').on('click', function(e){
    	e.preventDefault();
    	$(this).closest('li').remove();
    });
    
});