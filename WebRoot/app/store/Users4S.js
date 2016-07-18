//用户的数据集
Ext.create("Ext.data.Store", {
	model : 'User',
	storeId : 'UserStore',
	proxy : {
		type : 'ajax',
		url : 'superadmin/showUsers',
		reader : {
			type : 'json',
			root : 'list',
			success : "@success",
			totalProperty : 'totalCount'
		},
		writer : {
			type : 'json'
		}
	}
});