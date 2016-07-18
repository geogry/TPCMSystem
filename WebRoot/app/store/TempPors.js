//临时申购信息的数据集
Ext.create('Ext.data.Store', {
	model : 'TempPor',
	storeId : 'userTempPorStore',
	proxy : {
		type : 'ajax',
		url : 'user/showTempPors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});
