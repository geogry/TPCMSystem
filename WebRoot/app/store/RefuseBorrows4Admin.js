//已拒绝申领申请的数据集
Ext.create('Ext.data.Store', {
	model : 'RefuseBorrow',
	storeId : 'adminRefuseBorrowStore',
	proxy : {
		type : 'ajax',
		url : 'admin/showAllRefuseBorrows',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});