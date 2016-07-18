//已通过的申购请求的数据集
Ext.create('Ext.data.Store', {
	model : 'PassPor',
	storeId : 'adminPassPorStore',
	proxy : {
		type : 'ajax',
		url : 'common/showAllPassPors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});