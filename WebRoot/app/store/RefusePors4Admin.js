//已通过的申购请求的数据集
Ext.create('Ext.data.Store', {
	model : 'RefusePor',
	storeId : 'adminRefusePorStore',
	proxy : {
		type : 'ajax',
		url : 'admin/showAllRefusePors',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});