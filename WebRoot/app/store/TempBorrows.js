//临时借用信息的数据集
Ext.create('Ext.data.Store', {
	model : 'TempBorrow',
	storeId : 'userTempBorrowStore',
	proxy : {
		type : 'ajax',
		url : 'user/showTempBorrows',
		reader : {
			type : 'json',
			root : 'list',
			totalProperty : 'totalCount',
			successProperty : '@success'
		},
		actionMethods : {read : 'POST'}
	}
});