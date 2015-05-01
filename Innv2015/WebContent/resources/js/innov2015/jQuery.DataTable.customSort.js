/* Create an array with the values of all the input boxes in a column */
if ($.fn.dataTable !== undefined) {
	$.fn.dataTable.ext.order['dom-text'] = function(settings, col) {
		return this.api().column(col, {
			order : 'index'
		}).nodes().map(function(td, i) {
			return $('input', td).val();
		});
	};
}

/*
 * Create an array with the values of all the input boxes in a column, parsed as
 * numbers
 */
if ($.fn.dataTable !== undefined) {
	$.fn.dataTable.ext.order['dom-text-numeric'] = function(settings, col) {
		return this.api().column(col, {
			order : 'index'
		}).nodes().map(function(td, i) {
			return $('input', td).val() * 1;
		});
	};
}
/* Create an array with the values of all the select options in a column */
if ($.fn.dataTable !== undefined) {
	$.fn.dataTable.ext.order['dom-select'] = function(settings, col) {
		return this.api().column(col, {
			order : 'index'
		}).nodes().map(function(td, i) {
			return $('select', td).val();
		});
	};
}
/* Create an array with the values of all the checkboxes in a column */
if ($.fn.dataTable !== undefined) {
	$.fn.dataTable.ext.order['dom-checkbox'] = function(settings, col) {
		return this.api().column(col, {
			order : 'index'
		}).nodes().map(function(td, i) {
			return $('input', td).prop('checked') ? '1' : '0';
		});
	};
}
/* Create an array with the values of all the Dollar values in a column */
if ($.fn.dataTable !== undefined) {
	$.fn.dataTable.ext.order['dom-text-dollar'] = function(settings, col) {
		return this.api().column(col, {
			order : 'index'
		}).nodes().map(function(td, i) {
			return $('input', td).val().replace(/[,$]/g, '') * 1;
		});
	};
}
