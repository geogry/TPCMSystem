//已通过申购申请的数据集
Ext.create('Ext.data.Store', {
	model : 'PassPor',
	storeId : 'userPassPorStore',
	proxy : {
		type : 'ajax',
		url : 'user/showPassPors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});