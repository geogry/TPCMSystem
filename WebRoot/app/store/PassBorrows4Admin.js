//已通过申领申请的数据集
Ext.create('Ext.data.Store', {
	model : 'PassBorrow',
	storeId : 'adminPassBorrowStore',
	proxy : {
		type : 'ajax',
		url : 'common/showAllPassBorrows',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});