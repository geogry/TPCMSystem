//已通过申领申请的数据集
Ext.create('Ext.data.Store', {
	model : 'PassBorrow',
	storeId : 'userPassBorrowStore',
	proxy : {
		type : 'ajax',
		url : 'user/showPassBorrows',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});