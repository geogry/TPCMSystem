//已通过申购申请的数据集
Ext.create('Ext.data.Store', {
	model : 'RefusePor',
	storeId : 'userRefusePorStore',
	proxy : {
		type : 'ajax',
		url : 'user/showRefusePors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});