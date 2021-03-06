//提供给管理员的临时申领信息的数据集
Ext.create('Ext.data.Store', {
	model : 'TempPor',
	storeId : 'adminTempPorStore',
	proxy : {
		type : 'ajax',
		url : 'admin/showTempPors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});