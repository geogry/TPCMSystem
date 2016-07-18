Ext.create("Ext.data.Store", {
	model : 'User',
	storeId : 'RegisterUserStore',
	proxy : {
		type : 'ajax',
		url : 'admin/showRegisteUsers',
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