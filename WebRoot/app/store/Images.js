Ext.create('Ext.data.Store', {
	model : 'Image',
	storeId : 'ImageStore',
	proxy : {
		type : 'ajax',
		url : 'superadmin/showAllImage',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});