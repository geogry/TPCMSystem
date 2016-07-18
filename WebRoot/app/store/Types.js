//设备和耗材类型的数据集
Ext.create('Ext.data.Store', {
	model : 'Type',
	storeId : 'TypeStore',
	proxy : {
		type : 'ajax',
		url : 'common/showTypes',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			success : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});