//已通过申领申请的数据集
Ext.create('Ext.data.Store', {
	model : 'PassBorrow',
	storeId : 'returnPassBorrowStore',
	proxy : {
		type : 'ajax',
		url : 'user/showReturnPassBorrows',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});