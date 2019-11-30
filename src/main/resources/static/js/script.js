$(function() {

	$('.daterange').daterangepicker({
		"locale" : {
			"format" : "YYYY-MM-DD",
			"separator" : " to "
		}
	});

	$('.daterange').each(function(){
		console.log($(this).closest('.start-end-date').find('.start-date').val());
		$(this).data('daterangepicker').setStartDate($(this).closest('.start-end-date').find('.start-date').val());
		$(this).data('daterangepicker').setEndDate($(this).closest('.start-end-date').find('.end-date').val());
		
	});
	
	$('.reduced-price-button a').on('click', function(e) {
		e.preventDefault();
		var $reduced_prices_panel = $('.reduced-prices-panel');

		if ($reduced_prices_panel.hasClass('d-none')) {
			$reduced_prices_panel.removeClass('d-none');
			$('.reduced-price-button .far').removeClass('fa-eye');
			$('.reduced-price-button .far').addClass('fa-eye-slash');
		} else {
			$reduced_prices_panel.addClass('d-none');
			$('.reduced-price-button .far').removeClass('fa-eye-slash');
			$('.reduced-price-button .far').addClass('fa-eye');
		}
	});

	$('.supplier-select').on('change', function() {
		if ($(this).val()) {
			$('.supplier-select-panel .btn-success').removeClass('disabled');
		} else {
			$('.supplier-select-panel .btn-success').addClass('disabled');
		}
	});

	$('.supplier-select-panel .btn-success').on(
			'click',
			function(e) {
				e.preventDefault();

				var supplier_selected = $('.supplier-select').val();
				var if_added_supplier = false;

				$('.suppliers-panel li>input').each(function() {
					console.log(supplier_selected + ' ...' + $(this).val());
					if (supplier_selected == $(this).val()) {
						if_added_supplier = true;
					}
				});

				if (!if_added_supplier) {
					$supplier_item = $('.supplier-template').clone();
					$supplier_item.find('span').text(
							$('.supplier-select option:selected').text());
					$supplier_item.find('input').val(
							$('.supplier-select').val());

					$('.suppliers-panel ul').append($supplier_item);

					$supplier_item.removeClass('d-none');
				}
				$('.supplier-select').val('');
				$('.supplier-select').trigger('change');
			});

	$('.suppliers-panel .btn-danger').on('click', function(e) {
		e.preventDefault();
		$(this).closest('li').remove();
	});

});